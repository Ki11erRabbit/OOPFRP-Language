package utils;

import java.util.List;
import java.util.Map;

public class Neighborhood implements IObject {
    Map<String, IObject> neighbors;
    PostOffice postOffice;
    Address path;


    public Neighborhood(Map<String, IObject> neighbors, PostOffice postOffice, Address path) {
        this.neighbors = neighbors;
        this.postOffice = postOffice;
        this.path = path;
    }


    public int size() {
        return postOffice.size();
    }


    @Override
    public Message handleMessage(Message message) {
        List<String> remainingAddress = path.getRemainingAddress(message.getTo());
        if (neighbors.containsKey(remainingAddress.getFirst())) {
            message = neighbors.get(remainingAddress.getFirst()).handleMessage(message);
            postOffice.handleMessage(message);
            return null;
        } else {
            switch (message.getMessageName()) {
                case "addNeighbor":
                    neighbors.put(remainingAddress.getFirst(), message.getBody().getFirst());
                    return null;
                case "removeNeighbor":
                    IObject neighbor = neighbors.remove(remainingAddress.getFirst());
                    List<IObject> neighborList = List.of(neighbor);
                    return message.createResponse(neighborList);
                case "getNeighbors":
                    return message.createResponse(List.copyOf(neighbors.values()));
                default:
                    return messageFailed(message);
            }
        }
    }

    @Override
    public void tick() {
        for (IObject neighbor : neighbors.values()) {
            neighbor.tick();
        }
        postOffice.tick();
    }
}
