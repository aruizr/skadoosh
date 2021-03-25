package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.UserComposite;

public interface GetUserByIdUseCase {

    UserComposite getUserById(long id);

}
