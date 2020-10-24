package tech.Astolfo.ASON.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

class AParser {
    
    /**
     * @param f: At the moment an empty file, however this file will be equal to the final file that needs to be edited
     * @param HashI: An AtomicInteger made atomic to make it accessible during lambda expressions
     *             equal to the size of the HashMap value of the Object
     * @param SetI: An AtomicInteger made atomic to make it accessible during lambda expressions
     *            equal to the size of the HasSet value of the Object
     * @param fw: An Instance of the FileWriter class that is used to edit the file f
     */

    File f;
    URL url;
    AtomicInteger HashI = new AtomicInteger();
    AtomicInteger SetI = new AtomicInteger();
    FileWriter fw;

    /**
     * @param file the file that needs to be edited and parsed into JSON which will be equal to the previously defined
     *             file f
     */

    protected void FileParser(File file){
        this.f = file;
    }

    protected void UrlParser(URL url){
        this.url = url;
    }



    /**
     * @param Object the input parameters will be an Object
     *               this will be parsed into it's according data types and will be managed accordingly
     * @return true if the code is successful it will return true else it will throw an error
     */

    Function<Object, ?> GetTypes = (obj -> {

        try {
            fw = new FileWriter(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(obj instanceof HashMap){
            ((HashMap) obj).forEach((k,v)-> {
                HashI.set(((HashMap) obj).size());
                this.GetTypes.apply(k);
                try {
                    fw.append(":");

                    this.GetTypes.apply(v);

                    if(((HashMap) obj).size() == HashI.get()){
                        fw.append(";");
                    }else{
                        fw.append(",");
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }else if(obj instanceof HashSet){
            SetI.set(((HashSet) obj).size());
            ((HashSet) obj).forEach(v -> {
                try{
                    this.GetTypes.apply(obj);

                    if(((HashSet) obj).size() == SetI.get()){
                        fw.append(";");
                    }else {
                        fw.append(",");
                    }

                    SetI.getAndAdd(1);

                }catch (IOException e){
                    e.printStackTrace();
                }
            });
        }else if(obj instanceof String){
            try{
                fw.append("'" + obj.toString() + "'");
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            try{
                fw.append(obj.toString());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return true;
    });
}
