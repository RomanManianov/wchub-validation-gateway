package wchub.validation.gateway.impl.service.impl;

import org.springframework.stereotype.Service;
import wchub.validation.gateway.api.dto.UserDto;
import wchub.validation.gateway.impl.repository.UserRepository;
import wchub.validation.gateway.impl.repository.impl.CustomUserRepositoryImpl;
import wchub.validation.gateway.impl.security.ValidationService;
import wchub.validation.gateway.impl.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomUserRepositoryImpl customUserRepository;
    private final ValidationService validationService;

    public UserServiceImpl(UserRepository userRepository,
                           CustomUserRepositoryImpl customUserRepository,
                           ValidationService validationService) {
        this.userRepository = userRepository;
        this.customUserRepository = customUserRepository;
        this.validationService = validationService;
    }

    @Override
    public UserDto getUserForValidation(String uuid) {
        return customUserRepository.getUserByUUID(uuid);
    }

    @Override
    public UserDto getUserByLogin(String login) {
        return customUserRepository.getUserByLogin(login);
    }

    @Override
    public String addUserForValidation(UserDto user) {
        String message = "Доступ для пользователя " + user.getLogin() + " выдан успешно";
        if (!validationService.validateByLogin(user.getLogin())) {
            message = "Для пользователя " + user.getLogin() + " ранее уже был выдан доступ";
        }
        userRepository.saveAndFlush(user);

        return message;
    }
}
