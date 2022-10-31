package com.groupbyinc.auth.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("token")
public class TokenConfiguration {

    private String secret;
    private String issuer;
    private long ttl;

    public TokenConfiguration() {
    }

    public TokenConfiguration(String secret, String issuer, long ttl) {
        this.secret = secret;
        this.issuer = issuer;
        this.ttl = ttl;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
}
