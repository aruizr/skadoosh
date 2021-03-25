package cat.tcm.skadoosh.userservice.application.port.service;

import cat.tcm.skadoosh.userservice.application.port.in.GetAllUsersUseCase;
import cat.tcm.skadoosh.userservice.application.port.out.GetPostsByUserIdPort;
import cat.tcm.skadoosh.userservice.application.port.out.IUserDAO;
import cat.tcm.skadoosh.userservice.domain.User;
import cat.tcm.skadoosh.userservice.domain.UserComposite;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUsersService implements GetAllUsersUseCase {

    IUserDAO userDAO;
    GetPostsByUserIdPort getPostsByUserIdPort;

    public GetAllUsersService(IUserDAO userDAO, GetPostsByUserIdPort getPostsByUserIdPort) {
        this.userDAO = userDAO;
        this.getPostsByUserIdPort = getPostsByUserIdPort;
    }

    @Override
    public List<UserComposite> getAllUsers() {
        List<User> users = userDAO.findAll();
        return users
                .stream()
                .map(user -> new UserComposite(user, getPostsByUserIdPort.getPostsByUserId(user.getId())))
                .collect(Collectors.toList());
    }
}
