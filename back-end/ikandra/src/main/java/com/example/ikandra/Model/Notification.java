package com.example.ikandra.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    private Long id;

    @Column(name = "is_read")
    private Boolean is_read=false;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

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