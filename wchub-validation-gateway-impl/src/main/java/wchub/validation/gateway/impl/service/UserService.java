package wchub.validation.gateway.impl.service;

import wchub.validation.gateway.api.dto.UserDto;

public interface UserService {

    UserDto getUserForValidation(String uuid);

    UserDto getUserByLogin(String login);

    String addUserForValidation(UserDto user);
}
