package wchub.validation.gateway.impl.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wchub.validation.gateway.api.dto.UserDto;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class RestAuthorizeService {

    private final RestTemplate rest;
    private final Paths paths;

    @Autowired
    public RestAuthorizeService(@Qualifier("authorizeServiceRestTemplate") RestTemplate rest, Paths paths) {
        this.rest = rest;
        this.paths = paths;
    }

    public void sendCredentialsForAuthorizeUser(UserDto userCredentials) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDto> request = new HttpEntity<>(userCredentials, headers);

        rest.postForObject(getUriSendCredentialsForAuthorizeUser(), request, String.class);
    }

    private String getUriSendCredentialsForAuthorizeUser() {
        return paths.getAuthorizeSchema() + paths.getAuthorizeBaseUrl() + paths.getSendUserCreds();
    }
}
