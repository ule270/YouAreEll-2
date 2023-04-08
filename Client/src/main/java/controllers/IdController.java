package controllers;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Id;

public class IdController {
    private HashMap<String, Id> allIds;

    Id myId;

    public ArrayList<Id> getIds() {
        ArrayList <Id> Ids = new ArrayList<>();
        for(Map.Entry<String, Id> entry: allIds.entrySet()) {
            Ids.add(entry.getValue());
        }
        return Ids;
    }

    public Id postId(Id id) {

        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }

    public static void main(String[] args){
        try {
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                    .uri(new URI("http://zipcode.rocks:8085/ids"))
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            ObjectMapper objectMapper = new ObjectMapper();
            String body = response.body();
            System.out.println(body);

            List<Id> idList = objectMapper.readValue(body, new TypeReference<List<Id>>(){});
            for (int i =0; i < idList.size(); i++){
                System.out.println(idList.get(i));
            }

        } catch (Exception e) {

        }


    }
 
}