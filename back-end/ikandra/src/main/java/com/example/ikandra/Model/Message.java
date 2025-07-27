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
@Table(name = "message")
public class Message {

    @Id
    private Long id;

    @NotNull
    @Column(name = "send_at", nullable = false)
    private LocalDateTime send_at;

    @NotNull
    @Size(max = 255)
    @Column(name = "content", nullable = false, length = 255)
    private String content;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties({"offers", "notifications", "senderMessages", "receiverMessages", "senderTransactions", "receiverTransactions", "orders" })
    @JoinColumn(
        name = "user_id_sender",
        referencedColumnName = "id",
        nullable = false
    )
    private User sender;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties({"offers", "notifications", "senderMessages", "receiverMessages", "senderTransactions", "receiverTransactions", "orders" })
    @JoinColumn(
        name = "user_id_receiver",
        referencedColumnName = "id",
        nullable = false
    )
    private User receiver;

}
