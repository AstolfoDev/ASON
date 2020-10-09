package tech.Astolfo.ASON.JSON;

import java.io.FileWriter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class JSONWriter {

    AParser ap;
    ASON as;

    public void Writer(FileWriter fw){
        ap = new AParser();
        as = new ASON();
        AtomicInteger i = new AtomicInteger();
        Map data_json = as.get_json_data();

        data_json.forEach((k, v) ->{
            try {

                ap.GetTypes.apply(k);
                ap.GetTypes.apply(v);

            }catch (Exception e){
                e.printStackTrace();
            }

        });
    }
}
