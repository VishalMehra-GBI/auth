package com.groupbyinc.auth.repository;

import com.groupbyinc.auth.model.Tenant;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Integer> {
}