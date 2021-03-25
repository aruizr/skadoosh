package cat.tcm.skadoosh.postservice.adapter.messaging;

import cat.tcm.skadoosh.postservice.application.port.in.ICreatePostCase;
import cat.tcm.skadoosh.postservice.configuration.ReceiverChannel;
import cat.tcm.skadoosh.postservice.domain.Post;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ReceiverChannel.class)
public class MessageReceiver {

    ICreatePostCase createPostCase;

    public MessageReceiver(ICreatePostCase createPostCase) {
        this.createPostCase = createPostCase;
    }

    @StreamListener(ReceiverChannel.POST_CHANNEL)
    public void postReceiver(Post post) {
        createPostCase.createPost(post);
    }
}
