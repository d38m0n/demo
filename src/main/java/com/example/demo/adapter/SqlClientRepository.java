package com.example.demo.adapter;

import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClientEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlClientRepository extends ClientEntityRepository, JpaRepository<ClientEntity,String> {
}
