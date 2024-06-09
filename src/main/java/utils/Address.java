package utils;

import java.util.ArrayList;
import java.util.List;

public class Address {
    List<String> address;

    public Address() {
        address = new ArrayList<>();
    }

    public Address addPart(String part) {
        if (address == null)
            address = new ArrayList<>();

        address.add(part);
        return this;
    }
    public List<String> getRemainingAddress(Address other) {
        int index = 0;
        while (index < address.size() && index < other.address.size()) {
            if (!address.get(index).equals(other.address.get(index))) {
                return address.subList(index, address.size());
            }
            index++;
        }
        return address.subList(index - 1, address.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address other) {
            int index = 0;
            while (index < address.size() && index < other.address.size()) {
                if (!address.get(index).equals(other.address.get(index))) {
                    return false;
                }
                index++;
            }
            return true;
        }
        return false;
    }
}
