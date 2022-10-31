package com.groupbyinc.auth.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Table(name = "tenant")
@Entity
@Introspected
public class Tenant {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = false;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "active_key_1", nullable = false)
    private String activeKey1;

    @Column(name = "active_key_2")
    private String activeKey2;

    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @Column(name = "date_modified")
    private Instant dateModified;

    @Column(name = "settings", columnDefinition = "text", nullable = false)
    private String settings;

    @Column(name = "consul_name", columnDefinition = "text")
    private String consulName;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getConsulName() {
        return consulName;
    }

    public void setConsulName(String consulName) {
        this.consulName = consulName;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
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

    public String getActiveKey2() {
        return activeKey2;
    }

    public void setActiveKey2(String activeKey2) {
        this.activeKey2 = activeKey2;
    }

    public String getActiveKey1() {
        return activeKey1;
    }

    public void setActiveKey1(String activeKey1) {
        this.activeKey1 = activeKey1;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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