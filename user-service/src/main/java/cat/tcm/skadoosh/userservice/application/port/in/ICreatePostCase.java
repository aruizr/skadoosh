package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.Post;

public interface ICreatePostCase {
    void createPost(Post post);
}
