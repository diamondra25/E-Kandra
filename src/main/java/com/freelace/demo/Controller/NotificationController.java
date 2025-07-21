package com.freelace.demo.Controller;

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

import com.freelace.demo.Model.Notification;
import com.freelace.demo.Service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping()
    public List<Notification> getAll() {
        return notificationService.getAll();
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable Long id) {
        return notificationService.getById(id);
    }

    @PostMapping
    public Notification create(@RequestBody Notification notification) {
        return notificationService.create(notification);
    }

    @PutMapping("/{id}")
    public Notification update(@PathVariable Long id,@RequestBody Notification notificationDetails) {
        return notificationService.update(id, notificationDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notificationService.delete(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        notificationService.deleteAll();
    }
}
