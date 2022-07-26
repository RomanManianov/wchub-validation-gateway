package wchub.validation.gateway.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserDto {
    String id;
    String uuid;
    String login;
    String tempPassword;
    LocalDateTime timeStamp;
    boolean isAuthorizedNow;
}
