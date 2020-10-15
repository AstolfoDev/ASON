package tech.Astolfo.ASON.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

class AParser {
    /**
     * @param Object the input parameters will be an Object
     * return The Output will vary according to what the object type is this is 
     *              for easier classification of the object within the different possible types
     */

    protected Function<Object, ?> GetTypes = (obj -> {
        if(obj instanceof HashMap){
            return (HashMap) obj;
        }else if(obj instanceof HashSet){
            return (HashSet) obj;
        }else if(obj instanceof String){
            return (String) obj;
        }else {
            return obj;
        }
    });
}
