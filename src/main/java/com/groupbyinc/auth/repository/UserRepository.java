package com.groupbyinc.auth.repository;

import com.groupbyinc.auth.model.UserAccount;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserAccount, Integer> {
    Optional<UserAccount> findByEmail(String email);
}
