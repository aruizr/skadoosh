package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.User;

import java.util.List;

public interface IGetAllUsersCase {
    List<User> getAllUsers();
}
