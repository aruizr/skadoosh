package cat.tcm.skadoosh.userservice.application.service;

import cat.tcm.skadoosh.userservice.adapter.messaging.MessageSender;
import cat.tcm.skadoosh.userservice.application.port.in.ICreatePostCase;
import cat.tcm.skadoosh.userservice.domain.Post;
import org.springframework.stereotype.Service;

@Service
public class CreatePostCase implements ICreatePostCase {

    MessageSender messageSender;

    public CreatePostCase(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void createPost(Post post) {
        messageSender.sendCreatePost(post);
    }
}
