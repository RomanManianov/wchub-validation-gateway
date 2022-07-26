package wchub.validation.gateway.impl.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import wchub.validation.gateway.api.dto.UserDto;

@Slf4j
@Repository
public class CustomUserRepositoryImpl {

    private final JdbcTemplate jdbcTemplate;

    public CustomUserRepositoryImpl(@Qualifier("validation_jdbc") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDto getUserByUUID(String uuid) {
        UserDto user = new UserDto();
        try {
            user = jdbcTemplate.queryForObject(queryForGetUserByUUID(uuid), UserDto.class);
        } catch (EmptyResultDataAccessException e) {
            log.info("user not found", e);
        }
        return user;
    }

    public UserDto getUserByLogin(String login) {
        UserDto user = new UserDto();
        try {
            user = jdbcTemplate.queryForObject(queryForGetUserByLogin(login), UserDto.class);
        } catch (EmptyResultDataAccessException e) {
            log.info("user not found", e);
        }
        return user;
    }

    private String queryForGetUserByUUID(String uuid) {
        return "select \"login\" " +
                "from \"validation_db\" " +
                "where " +
                "uuid = '" + uuid + "'";
    }

    private String queryForGetUserByLogin(String login) {
        return "select \"user\" " +
                "from \"validation_db\" " +
                "where " +
                "login = '" + login + "'";
    }
}
