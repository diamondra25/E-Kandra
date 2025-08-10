package com.example.ikandra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.ikandra.Model.Message;
import com.example.ikandra.Service.MessageService;

@Controller
public class WebSocketMessageController {
    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message){
        return messageService.create(message);
    }
}
