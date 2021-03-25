package cat.tcm.skadoosh.userservice.application.port.out;

import cat.tcm.skadoosh.userservice.domain.Post;
import java.util.List;

public interface GetPostsByUserIdPort {

    List<Post> getPostsByUserId(long id);

}
