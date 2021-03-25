package cat.tcm.skadoosh.userservice.adapter.messaging;

import cat.tcm.skadoosh.userservice.application.port.out.CreatePostPort;
import cat.tcm.skadoosh.userservice.configuration.SenderChannel;
import cat.tcm.skadoosh.userservice.domain.Post;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SenderChannel.class)
public class MessageController implements CreatePostPort {

    MessageChannel postChannel;

    public MessageController(SenderChannel senderChannel) {
        this.postChannel = senderChannel.postChannel();
    }

    @Override
    public void createPost(Post post) {
        postChannel.send(MessageBuilder.withPayload(post).build());
    }
}
