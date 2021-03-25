package cat.tcm.skadoosh.userservice.web;

import cat.tcm.skadoosh.userservice.application.port.out.IUserDAO;
import cat.tcm.skadoosh.userservice.domain.Post;
import cat.tcm.skadoosh.userservice.domain.User;
import cat.tcm.skadoosh.userservice.domain.UserComposite;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserRestController {

    private IUserDAO userDAO;
    private RestTemplate restTemplate;

    public UserRestController(IUserDAO userDAO, RestTemplate restTemplate) {
        this.userDAO = userDAO;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/users/{id}")
    public UserComposite getUser(@PathVariable long id) {
        String url = "http://localhost:7001/users/{id}/posts";
        ResponseEntity<List<Post>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
        }, id);
        List<Post> posts = response.getBody();
        User user = userDAO.findById(id).orElse(null);
        return new UserComposite(user, posts);
    }
}
