package wchub.validation.gateway.api.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import wchub.validation.gateway.api.dto.UserDto;

@RequestMapping("/api/v1/admin")
public interface AdminResource {

    @ApiOperation("Дать пользователю права на трансляцию")
    @PostMapping(value = "/user")
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<String> addUserAccess(
            @ApiParam(value = "Принимает DTO пользователя для валидации")
            @RequestBody UserDto user
    );
}
