package wchub.validation.gateway.api.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wchub.validation.gateway.api.dto.UserDto;
import wchub.validation.gateway.api.dto.UserValidationDto;

@RequestMapping("/api/v1/validation/user")
public interface UserResource {

    @ApiOperation("Ввод параметров для валидации (логин + пароль)")
    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Валидация прошла успешно", response = String.class),
            @ApiResponse(code = 400, message = "Валидация не пройдена, запросите временный пароль у своего администратора", response = String.class)
    })
    ResponseEntity<?> validate(@RequestBody UserDto userCredentials);
}
