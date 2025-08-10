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
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mess_seq")
    private Long id;

    @Column(name = "send_at", nullable = true)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime send_at=LocalDateTime.now();

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
