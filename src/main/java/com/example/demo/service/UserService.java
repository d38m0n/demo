package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserReadModel;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.model.UserWriteModel;
import com.example.demo.repository.UserEntityRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserEntityRepository userRepo;
    private PasswordEncoder encoder;


    public UserService(UserEntityRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public UserEntity addNewUser(UserWriteModel source) {
        source.setPsw(encoder.encode(source.getPsw()));
        return userRepo
                .save(source.getUserEntity());
    }

    public List<UserReadModel> findAllUsers() {
        return userRepo.findAll().stream()
                .map(UserReadModel::new)
                .collect(Collectors.toList());
    }

    public List<UserReadModel> findAllBySortedUsers(Pageable pageable) {
        return userRepo
                .findAll(pageable)
                .getContent()
                .stream()
                .map(UserReadModel::new)
                .collect(Collectors.toList());
    }

    public boolean update(UserUpdateModel source) {
        if (!userRepo.existsById(source.getId())) return false;
        userRepo.findById(source.getId())
                .ifPresent(ue -> {
                    ue.updateFrom(source);
                    userRepo.save(ue);
                });
        return true;
    }

    public boolean delete(String idUser) {
        if (userRepo.existsById(idUser)) return false;
        userRepo.deleteById(idUser);
        return true;
    }

}

