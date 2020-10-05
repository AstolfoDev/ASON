package tech.Astolfo.ASON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class OpenFile {

    private ArrayList<String> OpenFromFile(File file) throws IOException {
        ArrayList<String> contents = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        for(String line = br.readLine(); line != null; line = br.readLine()){
            contents.add(line.toLowerCase());
        }
        return contents;
    }

    private ArrayList<String> OpenFromURL(URL url) throws IOException {
        ArrayList<String> urlcontents = new ArrayList<String>();
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200)
            throw new RuntimeException("could not connect to url " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
                urlcontents.add(sc.nextLine());
            }
        }
        return urlcontents;
    }

    public ArrayList<String> GetFileContents(File file) throws IOException {
        return OpenFromFile(file);
    }

    public ArrayList<String> GetURLContents(URL url) throws IOException{
        return OpenFromURL(url);
    }
}
