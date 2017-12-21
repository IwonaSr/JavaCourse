package collection_ImmutableClasses;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    //Immutable class - an immutable object is one that will not change the state after it is instantiated
    //final fields
    //immutable class don't have any satters
    public Location(int locationID, String description, Map<String,Integer> exists) {
        this.locationID = locationID;
        this.description = description;
//        this.exits = exists;
        this.exits = new HashMap<String, Integer>(exists);
        this.exits.put("Q", 0);
    }
//
//    public void addExit(String direction, int location) {s
//        exits.put(direction, location);
//    }
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
