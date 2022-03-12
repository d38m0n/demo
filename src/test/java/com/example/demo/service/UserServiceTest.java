package com.example.demo.service;

import com.example.demo.configuration.AppConfig;
import com.example.demo.exception.error.UserLoginExistException;
import com.example.demo.model.UserWriteModel;
import com.example.demo.repository.UserEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

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

}