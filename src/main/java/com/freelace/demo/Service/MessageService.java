package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Model.Message;
import com.freelace.demo.Repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message getById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message create(Message message) {
        return messageRepository.save(message);
    }

    public Message update(Long id, Message messageDetails) {
        Message message = getById(id);
        if (message != null) {
            message.setContent(messageDetails.getContent());
            message.setSend_at(messageDetails.getSend_at());
            return messageRepository.save(message);
        }
        return null;
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

    public void deleteAll() {
        messageRepository.deleteAll();
    }

    
    
}
