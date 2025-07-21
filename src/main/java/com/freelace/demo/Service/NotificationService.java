package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Model.Notification;
import com.freelace.demo.Repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification getById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification update(Long id, Notification notificationDetails) {
        Notification notification = getById(id);
        if (notification != null) {
            notification.setContent(notificationDetails.getContent());
            notification.setIs_read(notificationDetails.getIs_read());
            notification.setCreated_at(notificationDetails.getCreated_at());
            return notificationRepository.save(notification);
        }
        return null;
    }

    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }

    public void deleteAll() {
        notificationRepository.deleteAll();
    }
}
