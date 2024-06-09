package utils;

import java.util.ArrayList;

public interface IObject {


    Message handleMessage(Message message);

    default Message messageFailed(Message message) {
        return message.createFailedResponse("Message not understood");
    }

    default void tick() {
        // Do nothing by default
    }
}
