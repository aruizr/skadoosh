package cat.tcm.skadoosh.postservice.application.service;

import cat.tcm.skadoosh.postservice.application.port.in.IGetUserPostsCase;
import cat.tcm.skadoosh.postservice.application.port.out.IPostDAO;
import cat.tcm.skadoosh.postservice.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUSerPostsCase implements IGetUserPostsCase {

    IPostDAO postDAO;

    public GetUSerPostsCase(IPostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public List<Post> getUserPosts(long id) {
        return postDAO.getPostByUserId(id);
    }
}
