package tech.Astolfo.ASON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Add {

    public Add(String key, String string){

    }

    public Add(String key, int number){

    }

    public Add(String key, HashMap<Object, Object> map){

    }

    public Add(String key, HashSet<String> set){

    }

    public Add(String key, boolean bool){

    }

    public Add(String key){

    }

    void UploadToFile(String key, Object obj, File file) throws IOException {
        FileWriter write = new FileWriter(file);
        write.append("'" + key + "'" + obj);
    }

}
