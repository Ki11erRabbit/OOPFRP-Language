package utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class PostOffice implements IObject {

    Deque<Message> messageQueue;
    Map<String,Object> addressBook;

    public PostOffice(Map<String,Object> addressBook) {
        this.messageQueue = new ArrayDeque<>();
        this.addressBook = addressBook;
    }

    public int size() {
        return messageQueue.size();
    }

    @Override
    public Message handleMessage(Message message) {
        messageQueue.add(message);
        return null;
    }

    @Override
    public void tick() {
        Message message = messageQueue.poll();
        if (message == null) {
            return;
        }
        // TODO: Lookup message in address book and have it send it to the correct address
    }
}
