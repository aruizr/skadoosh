package cat.tcm.skadoosh.userservice.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SenderChannel {

    String POST_CHANNEL = "senderPostChannel";

    @Output(POST_CHANNEL)
    MessageChannel postChannel();
}
