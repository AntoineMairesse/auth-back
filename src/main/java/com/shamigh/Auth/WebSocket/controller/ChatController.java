package com.shamigh.Auth.WebSocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("http://localhost:4200")
public class ChatController {

    @MessageMapping("/test")
    @SendTo("/socket/someoneJoined")
    @CrossOrigin("http://localhost:4200")
    public String someoneJoined(String message) {
        System.out.println("ChatController");
        return message;
    }

}
