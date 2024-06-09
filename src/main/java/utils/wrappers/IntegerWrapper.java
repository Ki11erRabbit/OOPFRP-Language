package utils.wrappers;

import utils.Address;
import utils.IObject;
import utils.Message;

import java.util.List;

public class IntegerWrapper implements IObject {
    long data;

    public IntegerWrapper(long data) {
        this.data = data;
    }

    private Message add(Message message, IObject other) {
        if (other instanceof IntegerWrapper) {
            long otherData = ((IntegerWrapper) other).data;
            data += otherData;
            return message.createResponse(List.of((IObject) this));
        } else if (other instanceof FloatWrapper) {
            double otherData = ((FloatWrapper) other).data;
            otherData += data;
            return message.createResponse(List.of((IObject) new FloatWrapper(otherData)));
        } else {
            return message.createFailedResponse("Cannot add to non-integer or non-float");
        }
    }

    @Override
    public Message handleMessage(Message message) {
        return switch (message.getMessageName()) {
            case "toString" -> message.createResponse(List.of((IObject) new StringWrapper(Long.toString(data))));
            case "+" -> add(message, message.getBody().getFirst());
            /*case "-" -> subtract(message.getBody().getFirst());
            case "*" -> multiply(message.getBody().getFirst());
            case "/" -> divide(message.getBody().getFirst());
            case "//" -> divideFloor(message.getBody().getFirst());
            case "%" -> modulo(message.getBody().getFirst());*/
            default -> messageFailed(message);
        };
    }
}
