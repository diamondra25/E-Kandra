package com.example.ikandra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Notification;
import com.example.ikandra.Repository.NotificationRepository;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll(){
        return notificationRepository.findAll();
    }

    public Notification getByid(Long id){
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification create(Notification notification){
        return notificationRepository.save(notification);
    }

    public Notification update(Notification notification){
        Notification existNotif= notificationRepository.findById(notification.getId()).orElse(null);
        if(existNotif!=null){
            return notificationRepository.save(existNotif);
        }
        return null;
    }

    public void deleteById(Long id){
        notificationRepository.deleteById(id);
    }

    public void deleteAll(){
        notificationRepository.deleteAll();
    }

    public List<Notification> getByUser_Id(Long id){
        return notificationRepository.findByUser_Id(id);
    }
}
