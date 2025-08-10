package com.example.ikandra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ikandra.Model.Notification;
import com.example.ikandra.Service.NotificationService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping()
    public List<Notification> getAll(){
        return notificationService.getAll();
    }

    @GetMapping("/getByUser_Id")
    public List<Notification> getByUser_Id(@RequestParam("user_id") Long user_id){
        return notificationService.getByUser_Id(user_id);
    }
    

    @GetMapping("/{id}")
    public Notification getById(@PathVariable Long id){
        return notificationService.getByid(id);
    }

    @PostMapping()
    public Notification create(@RequestBody Notification notification){
        return notificationService.create(notification);
    }

    @PutMapping()
    public Notification update(@RequestBody Notification notification){
        return notificationService.update(notification);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id){
        notificationService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        notificationService.deleteAll();
    }
}
