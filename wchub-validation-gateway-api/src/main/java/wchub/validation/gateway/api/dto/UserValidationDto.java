package wchub.validation.gateway.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserValidationDto {
    private String login;
    private String tempPassword;
    boolean isValid;
}
