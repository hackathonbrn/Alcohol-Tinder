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

//    @PostMapping("/auth")
//    I dont know what i should write here


    @PostMapping("/getQueue")
    public List<User> getQueue(@RequestParam Long userId) {
        return new ArrayList<>();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepo.findById(id).get();
    }

}
