package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.Post;

public interface CreatePostUseCase {

    void createPost(Post post);
    
}
