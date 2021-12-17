import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

import com.example.restservice.RestServiceApplication;
import com.example.restservice.Structures.Building;
import com.example.restservice.Structures.Floor;
import com.example.restservice.Structures.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class RestApiClient {

    public static void main(String[] args) throws IOException{
        RestServiceApplication.main(args);
    }

    public static String getBuildingData(long id) throws IOException{

        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/buildings/build" + Long.toString(id)).openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            return response;
        }

        // an error happened
        return null;
    }

    public static void addFloorData(long id, String name, Room[] rooms) throws IOException{

    }

    public static void addBuildingData(long id, String name, Floor[] floors) throws IOException{

        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/buildings/build" + Long.toString(id)).openConnection();

        connection.setRequestMethod("POST");

        String postData = "id=" + URLEncoder.encode(Long.toString(id));
        postData += "&name=" + URLEncoder.encode(name);
        postData += "&floors=" + URLEncoder.encode(Arrays.toString(floors));

        connection.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(postData);
        wr.flush();

        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            System.out.println("POST was successful.");
        }
        else if(responseCode == 401){
            System.out.println("Wrong password.");
        }
    }
}