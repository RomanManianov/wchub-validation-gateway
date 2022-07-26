package wchub.validation.gateway.impl.security;

public interface ValidationService {
    boolean validate(String login, String password);
    boolean validateByLogin(String login);
}
