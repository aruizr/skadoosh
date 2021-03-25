package cat.tcm.skadoosh.userservice.application.port.service;

import cat.tcm.skadoosh.userservice.application.port.in.CreatePostUseCase;
import cat.tcm.skadoosh.userservice.application.port.out.CreatePostPort;
import cat.tcm.skadoosh.userservice.domain.Post;
import org.springframework.stereotype.Service;

@Service
public class CreatePostService implements CreatePostUseCase {

    CreatePostPort createPostPort;

    public CreatePostService(CreatePostPort createPostPort) {
        this.createPostPort = createPostPort;
    }

    @Override
    public void createPost(Post post) {
        createPostPort.createPost(post);
    }
}
