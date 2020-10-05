package tech.Astolfo.ASON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Add {

    public Add(String key, String string, File file) throws IOException {
        UploadToFile(key, string, file);
    }

    public Add(String key, int number, File file) throws IOException{
        UploadToFile(key, number, file);
    }

    public Add(String key, HashMap<Object, Object> map, File file) throws IOException{
        UploadToFile(key, map, file);
    }

    public Add(String key, HashSet<String> set, File file) throws IOException{
        UploadToFile(key, set, file);
    }

    public Add(String key, boolean bool, File file) throws IOException{
        UploadToFile(key, bool, file);
    }

    public Add(String key, File file) throws IOException{
        UploadToFile(key, null, file);
    }

    private void UploadToFile(String key, Object obj, File file) throws IOException {
        FileWriter write = new FileWriter(file);
        write.append("'" + key + "'" + obj);
    }

}
