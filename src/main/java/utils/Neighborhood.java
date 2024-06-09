package utils;

import java.util.Map;

public abstract class Neighborhood {
    Map<String, Neighborhood> neighbors;
    PostOffice postOffice;
    Address path;
}
