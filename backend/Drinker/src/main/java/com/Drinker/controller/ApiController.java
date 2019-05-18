package com.Drinker.controller;

import com.Drinker.model.Group;
import com.Drinker.model.Match;
import com.Drinker.model.Place;
import com.Drinker.model.User;
import com.Drinker.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AlcoholRepo alcoholRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlaceRepo placeRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private MatchRepo matchRepo;

    @PostMapping("/getQueue")
    public List<User> getQueue(@RequestParam Integer userId) {
        return new ArrayList<>();
    }

    @CrossOrigin(origins = "http://192.168.1.91:8080")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepo.findById(id).get();
    }

    @CrossOrigin(origins = "http://192.168.1.91:8080")
    @PostMapping("/createUser")
    public User createUser(String newUser) {
        JSONObject jsonUser = new JSONObject(newUser);
        String firstName = (String) jsonUser.get("firstName");
        String secondName = (String) jsonUser.get("secondName");
        String phone = (String) jsonUser.get("phone");
        ArrayList<Integer> alco = (ArrayList<Integer>) jsonUser.get("alco");
        ArrayList<Integer> interests = (ArrayList<Integer>) jsonUser.get("interest");
        ArrayList<Integer> places = (ArrayList<Integer>) jsonUser.get("place");


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
        Integer placeId = (Integer) jsonGroup.get("place");
        Place place = placeRepo.findById(placeId).get();

        Group group = new Group(date, name, comment, place);
        groupRepo.save(group);
        return group;
    }

    @PostMapping("/addToGroup")
    public void addUserToGroup(String groupAndUsers) {
        JSONObject jsonGroupAndUsers = new JSONObject(groupAndUsers);

        Integer groupId = (Integer) jsonGroupAndUsers.get("groupId");
        Group group = groupRepo.findById(groupId).get();

        ArrayList<Long> newUsers = (ArrayList<Long>) jsonGroupAndUsers.get("userIds");

        ArrayList<Long> usersInGroup = (ArrayList<Long>) group.getUsers();

        usersInGroup.addAll(newUsers);

        group.setUsers(usersInGroup);
        groupRepo.save(group);
    }

    @PostMapping("/updateUser")
    public User updateUser(String newInfoUser) {
        JSONObject jsonUser = new JSONObject(newInfoUser);
        Integer userId = jsonUser.getInt("id");
        String firstName = (String) jsonUser.get("firstName");
        String secondName = (String) jsonUser.get("secondName");
        String phone = (String) jsonUser.get("phone");
        ArrayList<Integer> alco = (ArrayList<Integer>) jsonUser.get("alco");
        ArrayList<Integer> interests = (ArrayList<Integer>) jsonUser.get("interest");
        ArrayList<Integer> places = (ArrayList<Integer>) jsonUser.get("place");


        User user = userRepo.findById(userId).get();
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setPhone(phone);
        user.setAlcohol(alco);
        user.setInterests(interests);
        user.setPlaces(places);

        userRepo.save(user);
        return user;
    }

    @CrossOrigin(origins = "192.168.1.172")
    @PostMapping("/like")
    public void checkMatch(@RequestBody String userPair) {
        JSONObject jsonUserPair = new JSONObject(userPair);
        System.out.println(userPair);

        Integer userId1 = (Integer) jsonUserPair.get("user1");
        Integer userId2 = (Integer) jsonUserPair.get("user2");


        User user1 = userRepo.findById(userId1).get();
        User user2 = userRepo.findById(userId2).get();

        Match foundMatch = matchRepo.findByUser2AndUser1(user1, user2);

        if (foundMatch == null)
        {
            Match newMatch = new Match(user1, user2, false);
            matchRepo.save(newMatch);
        }
        else foundMatch.setMutual(true);
    }

    @PostMapping("/addPhoto")
    public void addPhotoToUser() {
    }
}
