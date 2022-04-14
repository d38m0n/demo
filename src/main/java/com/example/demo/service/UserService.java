package com.example.demo.service;

import com.example.demo.controller.LoggerFilterUser;
import com.example.demo.entity.LogbookEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.error.UserLoginExistException;
import com.example.demo.exception.error.UserNotAuthorizationException;
import com.example.demo.exception.error.UserNotFoundException;
import com.example.demo.model.UserReadModel;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.model.UserWriteModel;
import com.example.demo.repository.LogbookEntityRepository;
import com.example.demo.repository.UserEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    public static final Logger loger = LoggerFactory.getLogger(UserService.class);
    private UserEntityRepository userRepo;
    private LogbookEntityRepository logbookRepo;
    private EvidenceService evidenceService;
    private PasswordEncoder encoder;

    public UserService(UserEntityRepository userRepo,
                       LogbookEntityRepository logbookRepo,
                       EvidenceService evidenceService,
                       PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.logbookRepo = logbookRepo;
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
        if (encoder.matches(source.getPsw(), userEntity.getPsw())) {
            UserEntity userAuthorization = userRepo.findByLogin(userEntity.getLogin())
                    .orElseThrow(() -> new UserLoginExistException("Login"));
            userAuthorization.addAuthorizationDate(logbookRepo.save(new LogbookEntity()));
            userRepo.save(userAuthorization);
        }
        return encoder.matches(source.getPsw(), userEntity.getPsw());
    }

    public UserReadModel findUserByIdModel(String idUser) {
        UserEntity userEntity = userRepo.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException(idUser));
        return new UserReadModel(userEntity);
    }

    UserEntity findUserByIdEntity(String idUser) {
        return userRepo.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException(idUser));
    }

    public List<UserReadModel> findFiveLastAddUsers() {
        return userRepo.findAll().stream()
                .sorted(Comparator.comparing(UserEntity::getCreatedOn).reversed())
                .limit(5)
                .map(UserReadModel::new)
                .collect(Collectors.toList());

    }

    @Async
    public CompletableFuture<List<UserReadModel>> findAllUsersAsync() {
        loger.info("async");
        return CompletableFuture.supplyAsync(() -> userRepo.findAll().stream()
                .map(UserReadModel::new)
                .collect(Collectors.toList()));
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

