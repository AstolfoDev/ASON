package tech.Astolfo.ASON.JSON;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// JSON object for storing the information and methods for JSON files
public class ASON {

    // Declares a map which will contain all the keys and values for the json file
    Map json_data = new HashMap();


    /**
     Retrieves the value of an entry from the map matching the key provided
     @param key the unique identifier used to locate the map entry
     @return void
     @throws RuntimeException
     */
    Object get(Object key) {

        // Checks to see if the key specified by the user exists in the map and throws an exception if it's non-existent
        if (!json_data.containsKey(key)) throw new RuntimeException();

        // Returns the value from the map associated with the key provided
        return json_data.get(key);
    }



    /**
     Retrieves all existing entries from the map
     @return void
     @throws RuntimeException
     */
    public Set get_all() {

        // Checks to see if there are any entries in the object and throws an error if there are none
        if (json_data.isEmpty()) throw new RuntimeException();

        // Grabs all the entries from the map
        return json_data.entrySet();
    }



    /**
     (Over)writes entries into the map
     @param key the unique identifier associated with the value in the map
     @param value the value associated with the key (unique identifier)
     @return void
     */
    public void set(Object key, Object value) {

        // Sets the entry in the map containing the json_data with the values provided
        json_data.put(key, value);
    }



    /**
     Writes entries in the map without overwriting existing keys
     @param key the unique identifier associated with the value in the map
     @param value the value associated with the key (unique identifier)
     @return void
     */
    public void set_safely(Object key, Object value) {

        // Sets the entry in the map if the key is not currently present in the json data
        json_data.putIfAbsent(key, value);
    }



    /**
     Deletes the entry that matches the key provided
     @param key the unique identifier used to locate the map entry
     @return void
     @throws RuntimeException
     */
    public void delete(Object key) {

        // Checks to see if the key specified by the user exists in the map and throws an exception if it's non-existent
        if (!json_data.containsKey(key)) throw new RuntimeException();

        // Removes the entry that has the key matching the one specified
        json_data.remove(key);
    }



    /**
     Deletes all existing entries from the map
     @return void
     @throws RuntimeException
     */
    public void delete_all() {

        // Checks to see if there are any entries in the object and throws an error if there are none
        if (json_data.isEmpty()) throw new RuntimeException();

        // Removes all the entries from the map
        json_data.clear();
    }

}

