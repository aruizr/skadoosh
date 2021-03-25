package cat.tcm.skadoosh.userservice.adapter.messaging;

import cat.tcm.skadoosh.userservice.configuration.SenderChannel;
import cat.tcm.skadoosh.userservice.domain.Post;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(SenderChannel.class)
public class MessageSender {

    MessageChannel postChannel;

    public MessageSender(SenderChannel postChannel) {
        this.postChannel = postChannel.postChannel();
    }

    public void sendCreatePost(Post post) {
        postChannel.send(MessageBuilder.withPayload(post).build());
    }
}