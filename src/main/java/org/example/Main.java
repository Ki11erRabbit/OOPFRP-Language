package org.example;

import utils.Address;
import utils.Message;
import utils.Neighborhood;
import utils.PostOffice;
import utils.wrappers.StringWrapper;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PostOffice postOffice = new PostOffice(null);
        Address address = new Address().addPart("Main");
        Neighborhood neighborhood = new Neighborhood(new HashMap<>(), postOffice, address);
        Message createStringMessage = new Message(
                new Address().addPart("Main").addPart("x"),
                null,
                null,
                "addNeighbor",
                null,
                List.of(new StringWrapper("Hello, World!"))
        );
        neighborhood.handleMessage(createStringMessage);

        Message printMessage = new Message(
                new Address().addPart("Main").addPart("x"),
                null,
                null,
                "print",
                null,
                null
        );
        neighborhood.handleMessage(printMessage);

        while (neighborhood.size() > 0) {
            neighborhood.tick();
        }

    }
}