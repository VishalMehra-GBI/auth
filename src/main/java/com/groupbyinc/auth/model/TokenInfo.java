
package com.groupbyinc.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sub",
    "roles",
    "iss",
    "userName",
    "userId",
    "nbf",
    "areaPermissions",
    "tenantName",
    "tenantId",
    "exp",
    "userRole",
    "iat",
    "settings"
})
@Generated("jsonschema2pojo")
public class TokenInfo {

    @JsonProperty("sub")
    private String sub;
    @JsonProperty("roles")
    private List<String> roles = null;
    @JsonProperty("iss")
    private String iss;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("nbf")
    private Long nbf;
    @JsonProperty("areaPermissions")
    private List<AreaPermission> areaPermissions = null;
    @JsonProperty("tenantName")
    private String tenantName;
    @JsonProperty("tenantId")
    private Long tenantId;
    @JsonProperty("exp")
    private Long exp;
    @JsonProperty("userRole")
    private String userRole;
    @JsonProperty("iat")
    private Long iat;

    @JsonProperty("settings")
    @JsonRawValue
    private String settings;

    @JsonProperty("sub")
    public String getSub() {
        return sub;
    }

    @JsonProperty("sub")
    public void setSub(String sub) {
        this.sub = sub;
    }

    @JsonProperty("roles")
    public List<String> getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @JsonProperty("iss")
    public String getIss() {
        return iss;
    }

    @JsonProperty("iss")
    public void setIss(String iss) {
        this.iss = iss;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("userId")
    public Long getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonProperty("nbf")
    public Long getNbf() {
        return nbf;
    }

    @JsonProperty("nbf")
    public void setNbf(Long nbf) {
        this.nbf = nbf;
    }

    @JsonProperty("areaPermissions")
    public List<AreaPermission> getAreaPermissions() {
        return areaPermissions;
    }

    @JsonProperty("areaPermissions")
    public void setAreaPermissions(List<AreaPermission> areaPermissions) {
        this.areaPermissions = areaPermissions;
    }

    @JsonProperty("tenantName")
    public String getTenantName() {
        return tenantName;
    }

    @JsonProperty("tenantName")
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    @JsonProperty("tenantId")
    public Long getTenantId() {
        return tenantId;
    }

    @JsonProperty("tenantId")
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @JsonProperty("exp")
    public Long getExp() {
        return exp;
    }

    @JsonProperty("exp")
    public void setExp(Long exp) {
        this.exp = exp;
    }

    @JsonProperty("userRole")
    public String getUserRole() {
        return userRole;
    }

    @JsonProperty("userRole")
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @JsonProperty("iat")
    public Long getIat() {
        return iat;
    }

    @JsonProperty("iat")
    public void setIat(Long iat) {
        this.iat = iat;
    }

    @JsonProperty("settings")
    public String getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(String settings) {
        this.settings = settings;
    }
}
