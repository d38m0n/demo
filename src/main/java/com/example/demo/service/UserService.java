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

    public boolean addNewUser(UserWriteModel source) {
        if (userRepo.existsByLogin(source.getLogin())) return false;
        source.setPsw(encoder.encode(source.getPsw()));
        userRepo.save(source.getUserEntity());
        return true;
    }

    public boolean changPassword(UserUpdateModel source) {
        if (!userRepo.existsByLogin(source.getLogin())) return false;
        UserEntity user = userRepo.findByLogin(source.getLogin()).orElseThrow();
        if (isMatchesPassword(source, user)) {
            user.setPsw(encoder.encode(source.getNewPsw()));
            userRepo.save(user);
            return true;
        }

        return false;
    }

    public boolean deleteUserById(String idUser) {
        if (userRepo.existsById(idUser)) return false;
        userRepo.deleteById(idUser);
        return true;
    }

    private boolean isMatchesPassword(UserUpdateModel source, UserEntity userEntity) {
        return encoder.matches(source.getPsw(), userEntity.getPsw());
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

    public boolean updateUserByModelUpdate(UserUpdateModel source) {
        if (!userRepo.existsById(source.getId())) return false;
        userRepo.findById(source.getId())
                .ifPresent(ue -> {
                    ue.updateFrom(source);
                    userRepo.save(ue);
                });
        return true;
    }

}

