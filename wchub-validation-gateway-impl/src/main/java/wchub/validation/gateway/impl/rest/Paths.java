package wchub.validation.gateway.impl.rest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Paths {

    @Value("${authorize-service.schema")
    private String authorizeSchema;

    @Value("${authorize-service.base-url")
    private String authorizeBaseUrl;

    @Value("${authorize-service.send-user-creds")
    private String sendUserCreds;
}
