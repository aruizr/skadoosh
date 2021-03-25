package cat.tcm.skadoosh.userservice.application.service;

import cat.tcm.skadoosh.userservice.application.port.in.IGetAllUsersCase;
import cat.tcm.skadoosh.userservice.application.port.out.IUserDAO;
import cat.tcm.skadoosh.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersCase implements IGetAllUsersCase {

    IUserDAO userDAO;

    public GetAllUsersCase(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
