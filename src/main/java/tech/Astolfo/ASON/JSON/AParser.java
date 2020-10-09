package tech.Astolfo.ASON.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

class AParser {

    /**
     * @param Object the input parameters will be an Object
     * return HashMap the function will output a HashMap
     */

    Function<Object, HashMap> convertHashMaps = (o -> (HashMap) o);

    /**
     * @param Object the input parameters will be an Object
     * return HashSett the function will output a HashSet
     */

    Function<Object, HashSet> convertSets = (o -> (HashSet) o);

    /**
     * @param Object the input parameters will be an Object
     * return String the function will output a String
     */

    Function<Object, String> convertString = (o -> (String) o);

    /**
     * @param Object the input parameters will be an Object
     * return Object in this case the function will output an Object
     */

    Function<Object, Object> returnObject = (o -> o);

    /**
     * @param Object the input parameters will be an Object
     * return Undefined output meaning the output can be anything
     *               changing it according to what type the Object can be converted too
     */

    protected Function<Object, ?> GetTypes = (obj -> {
        if(obj instanceof HashMap){
            return convertHashMaps.apply(obj);
        }else if(obj instanceof HashSet){
            return convertSets.apply(obj);
        }else if(obj instanceof String){
            return convertString.apply(obj);
        }else {
            return returnObject.apply(obj);
        }
    });
}
