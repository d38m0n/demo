package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository {
    boolean existsById(String id);
    boolean existsByLogin(String id);

    List<UserEntity> findAll();

    Optional<UserEntity> findById(String id);
    Optional<UserEntity> findByLogin(String id);

    Page<UserEntity> findAll(Pageable p);

    UserEntity save(UserEntity ue);

    void deleteById (String id);
    void delete (UserEntity entity);
}
