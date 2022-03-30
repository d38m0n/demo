package com.example.demo.repository;


import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.ItemEntity;

import java.util.List;
import java.util.Optional;

public interface ClientEntityRepository {

    boolean existsById(String id);
    void deleteById(String id);

    ClientEntity save(ClientEntity clientEntity);

    List<ClientEntity> findAll();

    Optional<ClientEntity> findById(String id);
}
