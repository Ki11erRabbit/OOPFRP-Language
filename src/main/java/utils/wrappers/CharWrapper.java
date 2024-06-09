package utils.wrappers;

import utils.Address;
import utils.IObject;
import utils.Message;

import java.util.List;

public class CharWrapper implements utils.IObject {
    char data;

    public CharWrapper(char data) {
        this.data = data;
    }



    @Override
    public Message handleMessage(Message message) {
        String messageName = message.getMessageName();
        return switch (messageName) {
            case "toString" -> message.createResponse(List.of((IObject) new StringWrapper(String.valueOf(data))));
            case "toInteger" -> message.createResponse(List.of((IObject) new IntegerWrapper((int) data)));
            default -> messageFailed(message);
        };
    }

}
