package com.freelace.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelace.demo.Model.User;
import com.freelace.demo.Service.UserService;

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById( @PathVariable Long id) {
        return userService.getById(id);
    }

    // @PostMapping
    // public User create(@RequestBody UserDto user, ) {
    //     return userService.create(user);
    // }

    // @PutMapping("/{id}")
    // public User update(@PathVariable Long id, @RequestBody User userDetails) {
    //     return userService.update(id, userDetails);
    // }
    
}
