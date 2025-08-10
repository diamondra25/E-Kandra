package com.example.ikandra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Message;
import com.example.ikandra.Repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    public Message getById(Long id){
        return messageRepository.findById(id).orElse(null);
    }

    public List<Message> getConversation(Long userid1, Long userid2){
        return messageRepository.findConversationBetweenUsers(userid1, userid2);
    }

    public Message create(Message message){
        return messageRepository.save(message);
    }

    public Message update(Message message){
        Message existMessage = messageRepository.findById(message.getId()).orElse(null);
        if(existMessage!=null){
            return messageRepository.save(existMessage);
        }
        return null;
    }

    public void deleteById(Long id){
        messageRepository.deleteById(id);
    }

    public void deleteAll(){
        messageRepository.deleteAll();
    }
}
