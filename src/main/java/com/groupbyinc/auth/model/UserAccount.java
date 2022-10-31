package com.groupbyinc.auth.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "user_account")
@Entity
@Introspected
public class UserAccount {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false, length = 80)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name="tenant_id", nullable=false)
    private Tenant tenant;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @Column(name = "date_modified")
    private Instant dateModified;

    @JsonRawValue
    @Column(name = "area_permissions", columnDefinition = "text")
    private String areaPermissions;

    @Column(name = "settings", nullable = false, columnDefinition = "text")
    private String settings;

    @Column(name = "role", nullable = false, length = 80)
    private String role;

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

    public String getAreaPermissions() {
        return areaPermissions;
    }

    public void setAreaPermissions(String areaPermissions) {
        this.areaPermissions = areaPermissions;
    }

    public Instant getDateModified() {
        return dateModified;
    }

    public void setDateModified(Instant dateModified) {
        this.dateModified = dateModified;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}