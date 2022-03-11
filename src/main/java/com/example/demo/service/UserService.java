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
        if (userRepo.existsByLogin(source.getLogin())) throw new IllegalArgumentException("This login is exist");
        source.setPsw(encoder.encode(source.getPsw()));
        userRepo.save(source.getUserEntity(evidenceService
                .addNewEvidenceEntityForPerson(source.getEvidence())));
    }

    public void changPassword(UserUpdateModel source) {

        UserEntity user = userRepo.findByLogin(source.getLogin())
                .orElseThrow(() -> new IllegalArgumentException("Not found this login"));
        if (isMatchesPassword(source, user)) {
            user.setPsw(encoder.encode(source.getNewPsw()));
            userRepo.save(user);
        } else {
            throw new IllegalArgumentException("No matches password");
        }

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

    public void updateUserByModelUpdate(UserUpdateModel source) {
        UserEntity userUpdated = userRepo.findById(source.getId())
                .orElseThrow(() -> new IllegalArgumentException("Not found this id")).updateFrom(source);
        userRepo.save(userUpdated);
    }

}

