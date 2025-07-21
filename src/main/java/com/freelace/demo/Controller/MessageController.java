package com.freelace.demo.Controller;

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

import com.freelace.demo.Model.Message;
import com.freelace.demo.Service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping()
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable Long id) {
        return messageService.getById(id);
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageService.create(message);
    }

    @PutMapping("/{id}")
    public Message update(@PathVariable Long id,@RequestBody Message messageDetails) {
        return messageService.update(id, messageDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        messageService.delete(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        messageService.deleteAll();
    }
}
