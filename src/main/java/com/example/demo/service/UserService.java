package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserReadModel;
import com.example.demo.model.UserWriteModel;
import com.example.demo.repository.EvidenceEntityRepository;
import com.example.demo.repository.UserEntityRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserEntityRepository userEntityRepository;
    private PasswordEncoder encoder;


    public UserService(UserEntityRepository userEntityRepository, PasswordEncoder encoder) {
        this.userEntityRepository = userEntityRepository;
        this.encoder = encoder;
    }

    public UserEntity addNewUser(UserWriteModel source) {
        source.setPsw(encoder.encode(source.getPsw()));
        return userEntityRepository
                .save(source.getUserEntity());
    }

    public List<UserReadModel> findAllUsers() {
        return userEntityRepository.findAll().stream()
                .map(UserReadModel::new)
                .collect(Collectors.toList());
    }

    public List<UserReadModel> findAllBySortedUsers(Pageable pageable) {
        return userEntityRepository
                .findAll(pageable)
                .getContent()
                .stream()
                .map(UserReadModel::new)
                .collect(Collectors.toList());
    }

    public boolean update(UserEntity userEntity) {
        if (notFindUser(userEntity.getId())) return false;
        userEntityRepository.findById(userEntity.getId())
                .ifPresent(ue -> {
                    ue.updateFrom(userEntity);
                    userEntityRepository.save(ue);
                });
        return true;
    }

    public boolean delete(String idUser) {
        if (notFindUser(idUser)) return false;
        userEntityRepository.deleteById(idUser);
        return true;
    }

    private boolean notFindUser(String idUser) {
        return !userEntityRepository.existsById(idUser);
    }
}

