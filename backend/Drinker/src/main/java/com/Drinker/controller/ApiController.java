package com.Drinker.controller;

import com.Drinker.model.User;
import com.Drinker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/getQueue")
    public List<User> getQueue(@RequestParam Long userId) {
        return new ArrayList<>();
    }

    @PostMapping("/getUser")
    public User getUser(@RequestParam Long userId) {
        return userRepo.findById(userId).get();
    }

    @GetMapping("/getUser/{id}")
    public User getU(@PathVariable("id") Long id) {
        return userRepo.findById(id).get();
    }

}
