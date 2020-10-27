package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/buyMovie")
    public Map<String, Object> buyMovie(@RequestParam("id") Integer userId) {
        return userService.buyMovie(userId);
    }
}
