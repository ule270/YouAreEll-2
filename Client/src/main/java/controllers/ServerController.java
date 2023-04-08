package controllers;

import models.Id;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";

    private ServerController svr = new ServerController();

    private ServerController() {}

    public static String shared() {
//        return svr;
        return null;
    }

    public String idGet() {
        // url -> /ids/
        // send the server a get with url
        // return json from server
        return null;
    }
    public String idPost(Id Id) {
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        return null;
    }
    public String idPut(Id Id) {
        // url -> /ids/
        return null;
    }


}

// ServerController.shared.doGet()