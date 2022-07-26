package wchub.validation.gateway.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wchub.validation.gateway.api.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String> {
}
