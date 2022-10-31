package com.groupbyinc.auth.model;

import io.micronaut.core.util.StringUtils;

public class GoogleLoginRequest {

    private String email;
    private String password;
    private String tenantId;
    private boolean returnSecureToken = true;

    public boolean isReturnSecureToken() {
        return returnSecureToken;
    }

    public void setReturnSecureToken(boolean returnSecureToken) {
        this.returnSecureToken = true;
    }

    public GoogleLoginRequest() {
    }

    public GoogleLoginRequest(String email, String password, String tenantId) {
        this.email = email;
        this.password = password;
        this.tenantId = StringUtils.isEmpty(tenantId) ? "" : tenantId;
        this.returnSecureToken = true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
