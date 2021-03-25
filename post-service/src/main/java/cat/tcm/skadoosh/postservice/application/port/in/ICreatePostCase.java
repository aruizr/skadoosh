package cat.tcm.skadoosh.postservice.application.port.in;

import cat.tcm.skadoosh.postservice.domain.Post;

public interface ICreatePostCase {
    void createPost(Post post);
}
