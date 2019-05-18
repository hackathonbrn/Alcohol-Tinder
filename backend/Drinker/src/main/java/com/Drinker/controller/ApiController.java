package com.Drinker.controller;

import com.Drinker.model.Group;
import com.Drinker.model.User;
import com.Drinker.repository.GroupRepo;
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

    @Autowired
    private GroupRepo groupRepo;

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
        User user = userRepo.findById(id).get();
        return user;
    }

}
