package cat.tcm.skadoosh.userservice.adapter.web;

import cat.tcm.skadoosh.userservice.application.port.in.CreatePostUseCase;
import cat.tcm.skadoosh.userservice.application.port.in.GetAllUsersUseCase;
import cat.tcm.skadoosh.userservice.application.port.in.GetUserByIdUseCase;
import cat.tcm.skadoosh.userservice.domain.Post;
import cat.tcm.skadoosh.userservice.domain.UserComposite;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    GetUserByIdUseCase getUserByIdUseCase;
    GetAllUsersUseCase getAllUsersUseCase;
    CreatePostUseCase createPostUseCase;

    public UserRestController(GetUserByIdUseCase getUserByIdUseCase, GetAllUsersUseCase getAllUsersUseCase, CreatePostUseCase createPostUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.createPostUseCase = createPostUseCase;
    }

    @GetMapping("/users")
    public List<UserComposite> getAllUsers() {
        return getAllUsersUseCase.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserComposite getUser(@PathVariable long id) {
        return getUserByIdUseCase.getUserById(id);
    }

    @PostMapping("/users/{id}/posts")
    public void createPost(@PathVariable long id, @RequestBody Post post) {
        post.setUserId(id);
        createPostUseCase.createPost(post);
    }
}
