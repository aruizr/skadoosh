package cat.tcm.skadoosh.userservice.application.port.service;

import cat.tcm.skadoosh.userservice.application.port.in.GetUserByIdUseCase;
import cat.tcm.skadoosh.userservice.application.port.out.GetPostsByUserIdPort;
import cat.tcm.skadoosh.userservice.application.port.out.IUserDAO;
import cat.tcm.skadoosh.userservice.domain.Post;
import cat.tcm.skadoosh.userservice.domain.User;
import cat.tcm.skadoosh.userservice.domain.UserComposite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserByIdService implements GetUserByIdUseCase {

    IUserDAO userDAO;
    GetPostsByUserIdPort getPostsByUserIdPort;

    public GetUserByIdService(IUserDAO userDAO, GetPostsByUserIdPort getPostsByUserIdPort) {
        this.userDAO = userDAO;
        this.getPostsByUserIdPort = getPostsByUserIdPort;
    }

    @Override
    public UserComposite getUserById(long id) {
        User user = userDAO.findById(id).orElse(null);
        List<Post> posts = getPostsByUserIdPort.getPostsByUserId(id);

        return new UserComposite(user, posts);
    }
}
