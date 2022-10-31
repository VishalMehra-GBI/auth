package com.groupbyinc.auth.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupbyinc.auth.config.GoogleIDPConfiguration;
import com.groupbyinc.auth.exceptions.GoogleIDPException;
import com.groupbyinc.auth.model.GoogleLoginRequest;
import com.groupbyinc.auth.model.GoogleLoginResponse;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Singleton
public class GoogleIDPService {

    private ObjectMapper mapper = new ObjectMapper();
    private HttpClient httpClient = HttpClient.newBuilder().build();
    private final GoogleIDPConfiguration idpConfiguration;

    public GoogleIDPService(GoogleIDPConfiguration idpConfiguration) {
        this.idpConfiguration = idpConfiguration;
    }

    public GoogleLoginResponse login(GoogleLoginRequest request) {
        try {
            String body = mapper.writeValueAsString(request);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(idpConfiguration.getUrl() + idpConfiguration.getKey()))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApply(s -> {
                try {
                    return mapper.readValue(s.body(), GoogleLoginResponse.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }).get();
        } catch (Exception e){
            throw new GoogleIDPException("Google IDP Login Failed", e);
        }
    };
}
