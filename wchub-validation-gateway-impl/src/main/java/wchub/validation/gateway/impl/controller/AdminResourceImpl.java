package wchub.validation.gateway.impl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wchub.validation.gateway.api.dto.UserDto;
import wchub.validation.gateway.api.resource.AdminResource;
import wchub.validation.gateway.impl.service.UserService;

@RestController
public class AdminResourceImpl implements AdminResource {

    private final UserService userService;

    public AdminResourceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> addUserAccess(UserDto user) {
        String message = userService.addUserForValidation(user);
        return ResponseEntity.ok(message);
    }
}
