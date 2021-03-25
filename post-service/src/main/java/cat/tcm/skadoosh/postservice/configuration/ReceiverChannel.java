package cat.tcm.skadoosh.postservice.configuration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiverChannel {

    String POST_CHANNEL = "receiverPostChannel";

    @Input(POST_CHANNEL)
    SubscribableChannel receiverPostChannel();
}
