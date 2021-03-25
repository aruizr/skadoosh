package cat.tcm.skadoosh.postservice.application.port.in;

import cat.tcm.skadoosh.postservice.domain.Post;

import java.util.List;

public interface IGetUserPostsCase {
    List<Post> getUserPosts(long id);
}
