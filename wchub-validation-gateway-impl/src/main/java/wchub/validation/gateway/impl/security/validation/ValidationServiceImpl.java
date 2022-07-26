package wchub.validation.gateway.impl.security.validation;

import org.springframework.stereotype.Service;
import wchub.validation.gateway.api.dto.UserDto;
import wchub.validation.gateway.impl.security.ValidationService;
import wchub.validation.gateway.impl.service.UserService;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final UserService userService;

    public ValidationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean validate(String login, String password) {
        UserDto user = userService.getUserByLogin(login);
        return user.getLogin().equals(login) & user.getTempPassword().equals(password) & !user.isAuthorizedNow();
    }

    @Override
    public boolean validateByLogin(String login) {
        UserDto user = userService.getUserByLogin(login);
        return user.getLogin().equals(login);
    }
}
