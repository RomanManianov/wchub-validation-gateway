package wchub.validation.gateway.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MessageDto {

    String uuid;
    String messageText;
    String recipientId;
}
