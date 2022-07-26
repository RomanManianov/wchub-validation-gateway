package wchub.validation.gateway.impl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import wchub.validation.gateway.api.dto.UserDto;
import wchub.validation.gateway.api.resource.UserResource;
import wchub.validation.gateway.impl.rest.RestAuthorizeService;
import wchub.validation.gateway.impl.security.ValidationService;

@RestController
public class UserResourceImpl implements UserResource {

    private final ValidationService validationService;
    private final RestAuthorizeService restAuthorizeService;

    public UserResourceImpl(ValidationService validationService, RestAuthorizeService restAuthorizeService) {
        this.validationService = validationService;
        this.restAuthorizeService = restAuthorizeService;
    }

    @Override
    public ResponseEntity<?> validate(UserDto userCredentials) {
        if (!validationService.validate(userCredentials.getLogin(), userCredentials.getTempPassword())) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        restAuthorizeService.sendCredentialsForAuthorizeUser(userCredentials);

        return ResponseEntity.ok(userCredentials);
    }
}
