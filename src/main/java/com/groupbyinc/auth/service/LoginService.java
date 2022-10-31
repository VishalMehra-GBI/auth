package com.groupbyinc.auth.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupbyinc.auth.config.TokenConfiguration;
import com.groupbyinc.auth.exceptions.LoginException;
import com.groupbyinc.auth.model.*;
import com.groupbyinc.auth.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import jakarta.inject.Singleton;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Singleton
public class LoginService {

    private UserRepository userRepository;
    private GoogleIDPService googleIDPService;
    private TokenConfiguration tokenConfiguration;
    private ObjectMapper mapper = new ObjectMapper();

    public LoginService(UserRepository userRepository, GoogleIDPService googleIDPService, TokenConfiguration tokenConfiguration) {
        this.userRepository = userRepository;
        this.googleIDPService = googleIDPService;
        this.tokenConfiguration = tokenConfiguration;
    }


    public LoginResponse login(LoginRequest loginRequest, String tenantID) {
        GoogleLoginResponse googleLoginResponse = googleIDPService.login(new GoogleLoginRequest(loginRequest.getEmail(), loginRequest.getPassword(), tenantID));
        UserAccount userAccount = userRepository.findByEmail(googleLoginResponse.getEmail()).orElseThrow(() -> new LoginException("User Not Found: " + loginRequest.getEmail()));
        try {
            List<AreaPermission> areaPermissions = mapper.readValue(userAccount.getAreaPermissions(), new TypeReference<List<AreaPermission>>(){});

            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(userAccount.getEmail());
            userInfo.setId(userAccount.getId());
            userInfo.setName(userAccount.getName());
            userInfo.setRole(userAccount.getRole());
            userInfo.setSettings(userAccount.getSettings());
            userInfo.setAreaPermissions(areaPermissions);
            userInfo.setTenantId(userAccount.getTenant().getId());

            LoginResponse response = new LoginResponse();
            response.setUserName(userAccount.getEmail());
            response.setAccessToken(getAccessToken(userAccount, areaPermissions));
            response.setExpiresIn(tokenConfiguration.getTtl());
            response.setRoles(List.of(userAccount.getRole()));
            response.setTenantSettings(userAccount.getTenant().getSettings());
            response.setUserInfo(userInfo);

            return response;
        } catch (Exception exception){
            throw new LoginException(exception);
        }
    }

    private String getAccessToken(UserAccount userAccount, List<AreaPermission> areaPermissions) throws JOSEException {
        TokenInfo tokenInfo = getTokenInfo(userAccount, areaPermissions);
        Map<String, Object> map = mapper.convertValue(tokenInfo, new TypeReference<Map<String, Object>>() {});
        String secret = tokenConfiguration.getSecret();
        return getAccessToken(map, secret);
    }

    private String getAccessToken(Map<String, Object> payload, String secret) throws JOSEException {
        JWSSigner signer = new MACSigner(Base64.getDecoder().decode(secret));
        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload(payload));
        jwsObject.sign(signer);
        String token = jwsObject.serialize();
        return token;
    }

    private TokenInfo getTokenInfo(UserAccount userAccount, List<AreaPermission> areaPermissions) {
        Instant now = Instant.now();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setAreaPermissions(areaPermissions);
        tokenInfo.setUserId(Long.valueOf(userAccount.getId()));
        tokenInfo.setRoles(List.of(userAccount.getRole()));
        tokenInfo.setTenantId(Long.valueOf(userAccount.getTenant().getId()));
        tokenInfo.setTenantName(userAccount.getTenant().getName());
        tokenInfo.setSub(userAccount.getEmail());
        tokenInfo.setUserName(userAccount.getName());
        tokenInfo.setUserRole(userAccount.getRole());
        tokenInfo.setIss(tokenConfiguration.getIssuer());
        tokenInfo.setIat(now.getEpochSecond());
        tokenInfo.setNbf(now.getEpochSecond());
        tokenInfo.setExp(now.plus(tokenConfiguration.getTtl(), ChronoUnit.SECONDS).getEpochSecond());
        return tokenInfo;
    }
}
