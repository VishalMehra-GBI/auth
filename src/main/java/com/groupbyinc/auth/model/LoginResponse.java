package com.groupbyinc.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;

public class LoginResponse {

    private String userName;
    private List<String> roles;
    @JsonRawValue private String tenantSettings;

    @JsonProperty("access_token") private String accessToken;
    @JsonProperty("token_type") private String tokenType = "BEARER";
    @JsonProperty("expires_in") private long expiresIn;
    @JsonProperty("refresh_token") private String refreshToken;
    @JsonProperty("user")private UserInfo userInfo;

    public String getTenantSettings() {
        return tenantSettings;
    }

    public void setTenantSettings(String tenantSettings) {
        this.tenantSettings = tenantSettings;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
