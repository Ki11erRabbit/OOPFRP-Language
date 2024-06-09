package utils;

import java.util.List;

public class Message {
    Address to;
    Address from;
    Address returnTo;
    String messageName;
    String responseName;
    List<IObject> body;
    String error;

    public Message(Address to, Address from, Address returnTo, String messageName, String responseName, List<IObject> body) {
        this.to = to;
        this.from = from;
        this.returnTo = returnTo;
        this.messageName = messageName;
        this.responseName = responseName;
        this.body = body;
    }

    public Message(Address to, Address from, Address returnTo, String messageName, String responseName, List<IObject> body, String error) {
        this.to = to;
        this.from = from;
        this.returnTo = returnTo;
        this.messageName = messageName;
        this.responseName = responseName;
        this.body = body;
        this.error = error;
    }

    public Message createResponse(List<IObject> body) {
        return new Message(returnTo, to, to, responseName, null, body);
    }

    public Message createFailedResponse(String error) {
        return new Message(from, to, to, responseName, null, null, error);
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public Address getReturnTo() {
        return returnTo;
    }

    public String getMessageName() {
        return messageName;
    }

    public List<IObject> getBody() {
        return body;
    }
}
