package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.User;
import cat.tcm.skadoosh.userservice.domain.UserComposite;

import java.util.List;

public interface GetAllUsersUseCase {

    List<UserComposite> getAllUsers();

}
