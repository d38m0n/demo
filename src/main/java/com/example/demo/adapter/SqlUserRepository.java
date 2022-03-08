package com.example.demo.adapter;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlUserRepository extends UserEntityRepository, JpaRepository<UserEntity, String> {

}
