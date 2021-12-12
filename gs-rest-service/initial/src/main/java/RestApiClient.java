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

        Scanner scanner = new Scanner(System.in);
        ObjectMapper m = new ObjectMapper();

        System.out.println("Welcome to the Building Info Command Line Editor.");
        System.out.println("Do you want to get or set a Building Info?");
        while (true) {
            System.out.println("(Type 'get' or 'set' now.)");
            String getOrSet = scanner.nextLine();
            if ("get".equalsIgnoreCase(getOrSet)) {
                System.out.println("Whose info do you want to get?");
                System.out.println("(Type a building id now.)");

                String input = scanner.nextLine();
                long id=Long.parseLong(input);

                String jsonString = getBuildingData(id);
                if(jsonString == null){
                    continue;
                }

                JSONObject jsonObject = new JSONObject(jsonString);

                Building building = m.readValue(jsonObject.toString(), Building.class);

                System.out.println(building.toString());

            } else if ("set".equalsIgnoreCase(getOrSet)) {
                System.out.println("Whose info do you want to set?");
                System.out.println("(Type a person's name now.)");
                String name = scanner.nextLine();

                System.out.println("When was " + name + " born?");
                System.out.println("(Type a year now.)");
                String birthYear = scanner.nextLine();

                System.out.println("Can you tell me about " + name + "?");
                System.out.println("(Type a sentence now.)");
                String about = scanner.nextLine();

                // setPersonData(name, birthYear, about, password);
            } else if ("exit".equalsIgnoreCase(getOrSet)) {
                break;
            }
        }

        scanner.close();
    }

    public static String getBuildingData(long id) throws IOException{

        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/buildings/" + Long.toString(id)).openConnection();

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

        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/buildings/" + Long.toString(id)).openConnection();

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