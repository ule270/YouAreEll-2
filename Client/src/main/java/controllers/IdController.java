package controllers;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import models.Id;
import models.Message;

public class IdController {
    private HashMap<String, Id> allIds;

    Id myId;

    public ArrayList<Id> getIds() {
        try {
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                    .uri(new URI("http://zipcode.rocks:8085/ids"))
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            String body = response.body();
            List<Id> idList = objectMapper.readValue(body, new TypeReference<List<Id>>() {
            });
            return (ArrayList<Id>) idList;
//            System.out.println(idList.size());
//            for (int i =0; i < idList.size(); i++){
//                System.out.println(idList.get(i).toString()+ "");
//            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return null;
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
//        try {
//            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
//                    .uri(new URI("http://zipcode.rocks:8085/ids"))
//                    .GET()
//                    .build();
//            HttpResponse<String> response = HttpClient
//                    .newBuilder()
//                    .build()
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response);
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//            String body = response.body();
//            System.out.println(body);
//
//            List <Id> idList = objectMapper.readValue(body, new TypeReference<List<Id>>(){});
//            System.out.println(idList.size());
//            for (int i =0; i < idList.size(); i++){
//                System.out.println(idList.get(i).toString()+ "");
//            }
//
//        } catch (Exception e) {
//            System.out.println("error" + e);
//
//        }
//        try {
//            ObjectMapper maps = new ObjectMapper();
//            String hello = "testing #2";
//            String fromId = "ule270";
//            String toId = "ChristaR";
//            Message mess = new Message(hello, fromId, toId);
//            String message = maps.writeValueAsString(mess);
//            HttpRequest request1 = (HttpRequest) HttpRequest.newBuilder()
//                    .uri(new URI("http://zipcode.rocks:8085/ids/ule/messages"))
//                    .POST(HttpRequest.BodyPublishers.ofString(message))
//                    .build();
//            HttpResponse<String> response1 = HttpClient
//                .newBuilder()
//                .build()
//                .send(request1, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response1.body());
//        } catch (Exception e) {
//            System.out.printf("error" + e);
//
//        }
    }
}