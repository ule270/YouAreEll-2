package controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public ArrayList<Message> getMessages() {
        try {
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                    .uri(new URI("http://zipcode.rocks:8085/messages"))
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
            List<Message> messList = objectMapper.readValue(body, new TypeReference<List<Message>>() {
            });
            return (ArrayList<Message>) messList;
        } catch (Exception e) {
            System.out.printf("error" + e);
        }
        return null;
    }
    public ArrayList<Message> getMessagesForId(String Id) {
        try {
            HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                    .uri(new URI("http://zipcode.rocks:8085/ids/"+ Id+"messages"))
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
            List<Message> messList = objectMapper.readValue(body, new TypeReference<List<Message>>() {
            });
            return (ArrayList<Message>) messList;
        } catch (Exception e) {
            System.out.printf("error" + e);
        }
        return null;
    }
    public Message getMessageForSequence(String seq) {

        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
//        try {
//            ObjectMapper maps = new ObjectMapper();
//            Message mess = new Message(msg, myId, toId);
//            String message = maps.writeValueAsString(mess);
//            HttpRequest request1 = (HttpRequest) HttpRequest.newBuilder()
//                    .uri(new URI("http://zipcode.rocks:8085/ids/ule/messages"))
//                    .POST(HttpRequest.BodyPublishers.ofString(message))
//                    .build();
//            HttpResponse<String> response1 = HttpClient
//                    .newBuilder()
//                    .build()
//                    .send(request1, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response1.body());
//        } catch (Exception e) {
//            System.out.printf("error" + e);
//
//        }
        return null;
    }
 
}