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
@Table(name="message")
public class Message {
    private @Id @GeneratedValue Long id;
    
    @Column(length = 255, nullable = false)
    private String content;

    @Column(nullable = false, columnDefinition = "timestamp(6) with time zone")
    private Timestamp send_at;

    @ManyToOne
    @JoinColumn(name = "user_id_sender", referencedColumnName = "id", nullable = false)
    private User sender; 

    @ManyToOne
    @JoinColumn(name = "user_id_receiver", referencedColumnName = "id", nullable = false)
    private User receiver; 
}
