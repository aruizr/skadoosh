package cat.tcm.skadoosh.userservice.application.service;

import cat.tcm.skadoosh.userservice.application.port.in.IGetUserPostsCase;
import cat.tcm.skadoosh.userservice.domain.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetUserPostsCase implements IGetUserPostsCase {

    @Value("${app.post-service.host}")
    private String postServiceHost;

    private RestTemplate restTemplate;
    private CircuitBreakerFactory circuitBreakerFactory;

    public GetUserPostsCase(RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplate = restTemplate;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Override
    public List<Post> getUserPosts(long id) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("post-service");
        String url = "http://" + postServiceHost + "/users/{id}/posts";

        List<Post> posts = circuitBreaker.run(() -> {
            ResponseEntity<List<Post>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
            }, id);
            return response.getBody();
        }, throwable -> {
            return new ArrayList<>();
        });

        return posts;
    }
}
