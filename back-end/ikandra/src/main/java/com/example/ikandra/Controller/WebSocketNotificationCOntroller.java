package com.example.ikandra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.ikandra.Model.Notification;
import com.example.ikandra.Service.NotificationService;

@Controller
public class WebSocketNotificationCOntroller {
    @Autowired
    private NotificationService notificationService;

    @MessageMapping("/notification")
    @SendTo("/topic/notifications")

    public Notification send(Notification notification) {
        return notificationService.create(notification);
    }

}

