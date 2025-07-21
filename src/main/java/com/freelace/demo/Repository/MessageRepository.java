package com.freelace.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelace.demo.Model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
