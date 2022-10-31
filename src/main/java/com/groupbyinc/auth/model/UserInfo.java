package com.groupbyinc.auth.model;

import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.List;

public class UserInfo {

    private long id;
    private String name;
    private String email;
    private long tenantId;
    private String role;
    @JsonRawValue private String settings;
    private List<AreaPermission> areaPermissions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public List<AreaPermission> getAreaPermissions() {
        return areaPermissions;
    }

    public void setAreaPermissions(List<AreaPermission> areaPermissions) {
        this.areaPermissions = areaPermissions;
    }
}
