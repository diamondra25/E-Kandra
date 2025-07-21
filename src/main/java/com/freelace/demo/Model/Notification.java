package com.freelace.demo.Model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="notification")
public class Notification {
    private @Id @GeneratedValue Long id;

    @Column(length = 255, nullable = false)
    private String content;

    private Boolean is_read;
    
    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user; 
}
