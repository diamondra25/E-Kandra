package com.example.ikandra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notif_seq")
    private Long id;

    @Column(name = "is_read")
    private Boolean is_read=false;

    @Column(name = "created_at", nullable = true)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_at=LocalDateTime.now();

    @NotNull
    @Size(max = 255)
    @Column(name = "content", nullable = false, length = 255)
    private String content;

    @NotNull
    @ManyToOne
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id",
        nullable = false
    )
    @JsonIgnoreProperties({"offers", "notifications", "senderMessages", "receiverMessages", "senderTransactions", "receiverTransactions", "orders" })
    private User user;
}