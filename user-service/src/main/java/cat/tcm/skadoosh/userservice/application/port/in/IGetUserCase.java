package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.User;

public interface IGetUserCase {
    User getUser(long id);
}
