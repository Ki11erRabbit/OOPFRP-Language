package utils.wrappers;

import utils.IObject;
import utils.Message;

import java.util.ArrayList;

public class StringWrapper implements IObject {
    String data;

    public StringWrapper(String data) {
        this.data = data;
    }

    @Override
    public Message handleMessage(Message message) {
        return switch (message.getMessageName()) {
            //case "toString" -> message.createResponse(data);
            //case "toInteger" -> message.createResponse(Integer.parseLong(data));
            //case "toFloat" -> message.createResponse(Double.parseDouble(data));
            case "print" -> {
                System.out.print(data);
                yield message.createResponse(new ArrayList<>());
            }
            case "println" -> {
                System.out.println(data);
                yield message.createResponse(new ArrayList<>());
            }
            default -> messageFailed(message);
        };
    }
}
