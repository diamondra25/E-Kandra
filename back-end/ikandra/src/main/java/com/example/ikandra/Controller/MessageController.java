package com.example.ikandra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ikandra.Model.Message;
import com.example.ikandra.Service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping()
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable Long id){
        return messageService.getById(id);
    }

    @GetMapping("/conversation/{user1Id}/{user2Id}")
    public List<Message> getConversation(@PathVariable Long user1Id, @PathVariable Long user2Id) {
        return messageService.getConversation(user1Id, user2Id);
    }

    @PostMapping()
    public Message create (@RequestBody Message message){
        return messageService.create(message);
    }

    @PutMapping()
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        messageService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        messageService.deleteAll();
    }
}
