package controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Sandbox {
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
        } catch (Exception e) {

        }
    }
}
