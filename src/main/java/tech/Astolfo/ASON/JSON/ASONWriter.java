package tech.Astolfo.ASON.JSON;

import java.io.File;

public class ASONWriter {

    private AParser ap = new AParser();

    public ASONWriter(File file, Object data) {
        try {
            ap.FileParser(file);
            ap.GetTypes.apply(data);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
