package cat.tcm.skadoosh.postservice.application.service;

import cat.tcm.skadoosh.postservice.application.port.in.ICreatePostCase;
import cat.tcm.skadoosh.postservice.application.port.out.IPostDAO;
import cat.tcm.skadoosh.postservice.domain.Post;
import org.springframework.stereotype.Service;

@Service
public class CreatePostCase implements ICreatePostCase {

    IPostDAO postDAO;

    public CreatePostCase(IPostDAO postDAO) {
        this.postDAO = postDAO;
    }


    @Override
    public void createPost(Post post) {
        postDAO.save(post);
    }
}
