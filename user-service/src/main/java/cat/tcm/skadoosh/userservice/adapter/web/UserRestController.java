package cat.tcm.skadoosh.userservice.adapter.web;

import cat.tcm.skadoosh.userservice.application.port.in.ICreatePostCase;
import cat.tcm.skadoosh.userservice.application.port.in.IGetAllUsersCase;
import cat.tcm.skadoosh.userservice.application.port.in.IGetUserCase;
import cat.tcm.skadoosh.userservice.application.port.in.IGetUserPostsCase;
import cat.tcm.skadoosh.userservice.domain.Post;
import cat.tcm.skadoosh.userservice.domain.User;
import cat.tcm.skadoosh.userservice.domain.UserComposite;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    IGetUserPostsCase getUserPostsCase;
    IGetUserCase getUserCase;
    ICreatePostCase createPostCase;
    IGetAllUsersCase getAllUsersCase;

    public UserRestController(IGetUserPostsCase getUserPostsCase, IGetUserCase getUserCase, ICreatePostCase createPostCase, IGetAllUsersCase getAllUsersCase) {
        this.getUserPostsCase = getUserPostsCase;
        this.getUserCase = getUserCase;
        this.createPostCase = createPostCase;
        this.getAllUsersCase = getAllUsersCase;
    }

    @GetMapping("/users")
    public List<UserComposite> getAllUsers() {
        List<User> users = getAllUsersCase.getAllUsers();
        List<UserComposite> usersComposite = new ArrayList<>();
        users.forEach(user -> usersComposite.add(new UserComposite(user, getUserPostsCase.getUserPosts(user.getId()))));
        return usersComposite;
    }

    @GetMapping("/users/{id}")
    public UserComposite getUser(@PathVariable long id) {
        User user = getUserCase.getUser(id);
        List<Post> posts = getUserPostsCase.getUserPosts(id);
        return new UserComposite(user, posts);
    }

    @PostMapping("/users/{id}/posts")
    public void createPost(@PathVariable long id, @RequestBody Post post) {
        post.setUserId(id);
        createPostCase.createPost(post);
    }
}
