package com.groupbyinc.auth.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("google.idp")
public class GoogleIDPConfiguration {

    private String url;
    private String key;

    public GoogleIDPConfiguration() {
    }

    public GoogleIDPConfiguration(String url, String key) {
        this.url = url;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
