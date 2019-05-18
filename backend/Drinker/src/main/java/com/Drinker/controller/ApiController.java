package com.Drinker.controller;

import com.Drinker.model.Group;
import com.Drinker.model.Place;
import com.Drinker.model.User;
import com.Drinker.repository.GroupRepo;
import com.Drinker.repository.PlaceRepo;
import com.Drinker.repository.UserRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlaceRepo placeRepo;

    @Autowired
    private GroupRepo groupRepo;

    @PostMapping("/getQueue")
    public List<User> getQueue(@RequestParam Long userId) {
        return new ArrayList<>();
    }

    @CrossOrigin(origins = "http://192.168.1.91:8080")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepo.findById(id).get();
    }

    @CrossOrigin(origins = "http://192.168.1.91:8080")
    @PostMapping("/createUser")
    public User createUser(String newUser) {
        JSONObject jsonUser = new JSONObject(newUser);
        String firstName = (String) jsonUser.get("firstName");
        String secondName = (String) jsonUser.get("secondName");
        String phone = (String) jsonUser.get("phone");
        ArrayList<Long> alco = (ArrayList<Long>) jsonUser.get("alco");
        ArrayList<Long> interests = (ArrayList<Long>) jsonUser.get("interest");
        ArrayList<Long> places = (ArrayList<Long>) jsonUser.get("place");


        User user = new User(firstName, secondName, phone, 5.0, "file", alco, interests, places);
        userRepo.save(user);
        return user;
    }

    @PostMapping("/createGroup")
    public Group createGroup(String newGroup) {
        JSONObject jsonGroup = new JSONObject(newGroup);

        Date date = (Date) jsonGroup.get("date");
        String name = (String) jsonGroup.get("name");
        String comment = (String) jsonGroup.get("comment");
        Long placeId = (Long) jsonGroup.get("place");
        Place place = placeRepo.findById(placeId).get();

        Group group = new Group(date, name, comment, place);
        groupRepo.save(group);
        return group;
    }

    @PostMapping("/addToGroup")
    public void addUserToGroup(String groupAndUsers) {
        JSONObject jsonGroupAndUsers = new JSONObject(groupAndUsers);

        Long groupId = (Long) jsonGroupAndUsers.get("groupId");
        Group group = groupRepo.findById(groupId).get();

        ArrayList<Long> newUsers = (ArrayList<Long>) jsonGroupAndUsers.get("userIds");

        ArrayList<Long> usersInGroup = (ArrayList<Long>) group.getUsers();

        usersInGroup.addAll(newUsers);

        group.setUsers(usersInGroup);
        groupRepo.save(group);
    }
}
