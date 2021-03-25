package cat.tcm.skadoosh.userservice.application.port.out;

import cat.tcm.skadoosh.userservice.domain.Post;

public interface CreatePostPort {

    void createPost(Post post);

}
