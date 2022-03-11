package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.error.UserLoginExistException;
import com.example.demo.exception.error.UserNotAuthorizationException;
import com.example.demo.exception.error.UserNotFoundException;
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
    private EvidenceService evidenceService;
    private PasswordEncoder encoder;

    public UserService(UserEntityRepository userRepo,
                       EvidenceService evidenceService,
                       PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.evidenceService = evidenceService;
        this.encoder = encoder;
    }

    public void addNewUser(UserWriteModel source) {
        if (userRepo.existsByLogin(source.getLogin())) throw new UserLoginExistException(source.getLogin());
        source.setPsw(encoder.encode(source.getPsw()));
        userRepo.save(source.getUserEntity(evidenceService
                .addNewEvidenceEntityForPerson(source.getEvidence_id())));
    }

    public void changPassword(UserUpdateModel source) {

        UserEntity user = userRepo.findByLogin(source.getLogin())
                .orElseThrow(() -> new UserNotFoundException(source.getLogin()));
        if (isMatchesPassword(source, user)) {
            user.setPsw(encoder.encode(source.getNewPsw()));
            userRepo.save(user);
        } else {
            throw new UserNotAuthorizationException(source.getId());
        }

    }

    private boolean isMatchesPassword(UserUpdateModel source, UserEntity userEntity) {
        return encoder.matches(source.getPsw(), userEntity.getPsw());
    }

    public UserReadModel findUserById(String idUser) {
        UserEntity userEntity = userRepo.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException(idUser));
        return new UserReadModel(userEntity);
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

    public void updateUserByModelUpdate(UserUpdateModel source) {
        UserEntity userUpdated = userRepo.findById(source.getId())
                .orElseThrow(() -> new UserNotFoundException(source.getId()))
                .updateFrom(source);
        userRepo.save(userUpdated);
    }

}

