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
    public List<Object> getQueue(@RequestParam Long userId) {
        return new ArrayList<>();
    }

    @PostMapping("/getUser")
    public Object getUser(@RequestParam Long userId) {
        return new Object();
    }

    @GetMapping("/getUser/{id}")
    public User getU(@PathVariable Long id) {
        return userRepo.findById(id).get();
    }

}
