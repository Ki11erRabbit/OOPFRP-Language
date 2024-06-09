package utils;

import java.util.List;

public class Message {
    Address to;
    Address from;
    Address return_to;
    String message_name;
    List<Data> body;

    public Message(Address to, Address from, Address return_to, String message_name, List<Data> body) {
        this.to = to;
        this.from = from;
        this.return_to = return_to;
        this.message_name = message_name;
        this.body = body;
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public Address getReturn_to() {
        return return_to;
    }

    public String getMessage_name() {
        return message_name;
    }

    public List<Data> getBody() {
        return body;
    }
}
