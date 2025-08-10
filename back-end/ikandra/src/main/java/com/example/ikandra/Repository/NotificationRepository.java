package com.example.ikandra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Notification;

public interface NotificationRepository extends JpaRepository <Notification, Long> {
    List<Notification>findByUser_Id(Long id);
}
