package com.example.demo.service;

import com.example.demo.configuration.AppConfig;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.error.UserLoginExistException;
import com.example.demo.model.UserWriteModel;
import com.example.demo.repository.UserEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Import({AppConfig.class})
class UserServiceTest {

    @Test
    @DisplayName("show UserLoginExistException if login exist in db")
    void create_user_write_model_check_exist_and_throw_UserLoginExistException() {
//         give
        var encoder = mock(PasswordEncoder.class);
        var evidenceService = mock(EvidenceService.class);
        var mockUserExist = mock(UserEntityRepository.class);
        var mockUserService = new UserService(mockUserExist, evidenceService, encoder);
        var userWriteModel = new UserWriteModel();

//       when
        when(mockUserExist.existsByLogin(anyString())).thenReturn(true);
        userWriteModel.setLogin("test");

//       give
        assertThatThrownBy(() -> mockUserService.addNewUser(userWriteModel))
                .isInstanceOf(UserLoginExistException.class)
                .hasMessageContaining("test");
    }

    @Test
    void test_memory_user_repository(){

        inMemoryUsersRepository().save(new UserEntity());
        int size = inMemoryUsersRepository().findAll().size();
        System.out.println(size);
    }

    private UserEntityRepository inMemoryUsersRepository() {
        return new UserEntityRepository() {
            private int index = 0;
            private Map<String, UserEntity> map = new HashMap<>();

            @Override
            public boolean existsByLogin(String id) {
                return map.values().stream()
                        .allMatch(entity -> entity.getLogin().equals(id));
            }

            @Override
            public List<UserEntity> findAll() {
                return new ArrayList<>(map.values());
            }

            @Override
            public Optional<UserEntity> findById(String id) {
                return Optional.ofNullable(map.get(id));
            }

            @Override
            public Optional<UserEntity> findByLogin(String id) {
                return map.values().stream()
                        .filter(entity -> entity.getLogin().equals(id))
                        .findFirst();

            }

            @Override
            public Page<UserEntity> findAll(Pageable p) {
                ArrayList<UserEntity> userEntities = new ArrayList<>(map.values());
                return new PageImpl<>(userEntities,
                        p,
                        userEntities.size());
            }

            @Override
            public UserEntity save(UserEntity ue) {
                if (ue.getId() == null) {
                    try {

                        Field field = UserEntity.class.getDeclaredField("id"); // reflection
                        field.setAccessible(true);
                        field.set(ue, String.valueOf(++index));
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                map.put(ue.getId(), ue);
                return ue;
            }

        };
    }

}