package utils;

public interface IObject {

    Address getPath();

    Message handleMessage(Message message);

    default Message messageFailed(Message message) {
        return new Message(message.getReturn_to(), getPath(), getPath(), "Message Not Found", null);
    }
}
