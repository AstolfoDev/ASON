package tech.Astolfo.ASON.JSON;

import java.util.HashMap;
import java.util.Map;

// JSON object for storing the information and methods for JSON files
public class ASON {

    // Declares a map which will contain all the keys and values for the json file
    Map json_data = new HashMap();

    // Method for retrieving information from the map
    public Object get(Object key) {

        // Checks to see if the key specified by the user exists in the map and throws an exception if it's non-existent
        if (!json_data.containsKey(key)) throw new RuntimeException();

        // Returns the value from the map associated with the key provided
        return json_data.get(key);
    }

    // Method for (over)writing entries in the map
    public void set(Object key, Object value) {

        // Sets the entry in the map containing the json_data with the values provided
        json_data.put(key, value);
    }

    // Method for writing entries in the map without overwriting existing keys
    public void set_safely(Object key, Object value) {

        // Sets the entry in the map if the key is not currently present in the json data
        json_data.putIfAbsent(key, value);
    }

}

