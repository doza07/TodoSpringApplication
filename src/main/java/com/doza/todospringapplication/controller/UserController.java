package com.doza.todospringapplication.controller;

import com.doza.todospringapplication.entity.User;
import com.doza.todospringapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestParam(required = false) String username, @RequestParam(required = false) String email,
                           @RequestParam(required = false) String password, @RequestParam(required = false) LocalDate birthday) {
        userService.update(id, username, email, password, birthday);
    }

    @GetMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}

