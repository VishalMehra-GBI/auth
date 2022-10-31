
package com.groupbyinc.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "areaId",
    "role"
})
@Generated("jsonschema2pojo")
public class AreaPermission {

    @JsonProperty("areaId")
    private Long areaId;
    @JsonProperty("role")
    private Role role;

    @JsonProperty("areaId")
    public Long getAreaId() {
        return areaId;
    }

    @JsonProperty("areaId")
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @JsonProperty("role")
    public Role getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(Role role) {
        this.role = role;
    }

}
