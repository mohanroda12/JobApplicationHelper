package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepositoryInterface extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
