package com.freelace.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelace.demo.Model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
}
