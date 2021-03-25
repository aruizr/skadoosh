package cat.tcm.skadoosh.postservice.application.port.out;

import cat.tcm.skadoosh.postservice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostDAO extends JpaRepository<Post, Long> {
    List<Post> getPostByUserId(long userId);
}