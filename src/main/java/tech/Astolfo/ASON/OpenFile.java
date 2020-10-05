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

    /**
     * @param file User enters specified file which will be iterated through
     * @return returns an ArrayList with every line of the json file saved in it line by line in order
     * @throws IOException
     */

    private ArrayList<String> OpenFromFile(File file) throws IOException {
        ArrayList<String> contents = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        for(String line = br.readLine(); line != null; line = br.readLine()){ //for loop that iterates through every line untill the first blank line
            contents.add(line.toLowerCase()); 
        }
        return contents;
    }

    /**
     *
     * @param url User enters the URL the JSON is saved in common uses include: reading API's
     * @return returns an ArrayList with every line of the json file saved in it line by line in order
     * @throws IOException
     */

    private ArrayList<String> OpenFromURL(URL url) throws IOException {
        ArrayList<String> urlcontents = new ArrayList<String>();
        HttpURLConnection conn = (HttpURLConnection)url.openConnection(); //starts a connection
        conn.setRequestMethod("GET"); //sets the request method to get informaiton
        conn.connect(); //connects
        int responsecode = conn.getResponseCode(); //gets response code, 200 if successfull
        if(responsecode != 200)
            throw new RuntimeException("could not connect to url " + responsecode);
        else {
            Scanner sc = new Scanner(url.openStream()); //read the content of the page
            while(sc.hasNext()) { //while the next line is not blank
                urlcontents.add(sc.nextLine()); //add to the arraylist the contents of the line
            }
        }
        return urlcontents;
    }

    /**
     * litterally just a getter for the file ArrayList so to not make it public and have anyone access the function (AKA a safety measure)
     */

    public ArrayList<String> GetFileContents(File file) throws IOException {
        return OpenFromFile(file);
    }

    /**
     * Same thing as above but with the URL one
     */

    public ArrayList<String> GetURLContents(URL url) throws IOException{
        return OpenFromURL(url);
    }
}
