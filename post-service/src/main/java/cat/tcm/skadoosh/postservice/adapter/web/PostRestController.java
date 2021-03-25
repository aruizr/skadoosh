package cat.tcm.skadoosh.postservice.adapter.web;

import cat.tcm.skadoosh.postservice.application.port.in.IGetUserPostsCase;
import cat.tcm.skadoosh.postservice.domain.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRestController {

    IGetUserPostsCase getUserPostsCase;

    public PostRestController(IGetUserPostsCase getUserPostsCase) {
        this.getUserPostsCase = getUserPostsCase;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable long id) {
        return getUserPostsCase.getUserPosts(id);
    }
}
