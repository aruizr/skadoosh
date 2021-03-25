package cat.tcm.skadoosh.userservice.application.service;

import cat.tcm.skadoosh.userservice.application.port.in.IGetUserCase;
import cat.tcm.skadoosh.userservice.application.port.out.IUserDAO;
import cat.tcm.skadoosh.userservice.domain.User;
import org.springframework.stereotype.Service;

@Service
public class GetUserCase implements IGetUserCase {

    IUserDAO userDAO;

    public GetUserCase(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(long id) {
        return userDAO.findById(id).orElse(null);
    }
}
