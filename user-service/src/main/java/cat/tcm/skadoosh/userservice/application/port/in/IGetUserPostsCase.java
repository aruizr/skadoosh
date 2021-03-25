package cat.tcm.skadoosh.userservice.application.port.in;

import cat.tcm.skadoosh.userservice.domain.Post;

import java.util.List;

public interface IGetUserPostsCase {
    List<Post> getUserPosts(long id);
}
