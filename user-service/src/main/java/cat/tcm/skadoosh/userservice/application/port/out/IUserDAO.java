package cat.tcm.skadoosh.userservice.application.port.out;

import cat.tcm.skadoosh.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<User, Long> {
}
