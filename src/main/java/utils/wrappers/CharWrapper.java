package utils.wrappers;

import utils.Address;
import utils.Message;

import java.util.List;

public class CharWrapper implements utils.Data, utils.IObject {
    char data;
    Address path;

    public CharWrapper(char data) {
        this.data = data;
    }

    public void setAddress(Address path) {
        this.path = path;
    }

    @Override
    public Address getPath() {
        return path;
    }

    @Override
    public Message handleMessage(Message message) {
        String message_name = message.getMessage_name();
        return switch (message_name) {
            case "toString" -> new Message(
                    message.getReturn_to(),
                    getPath(),
                    message.getReturn_to(),
                    "",
                    List.of(new StringWrapper(String.valueOf(data)))
            );
            case "toInteger" -> new Message(
                    message.getReturn_to(),
                    getPath(),
                    null,
                    "",
                    List.of(new IntWrapper(data))
            );
            default -> messageFailed(message);
        };
    }

}
