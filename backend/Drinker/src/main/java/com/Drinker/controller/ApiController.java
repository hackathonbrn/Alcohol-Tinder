package com.Drinker.controller;

import com.Drinker.model.Group;
import com.Drinker.model.Match;
import com.Drinker.model.Place;
import com.Drinker.model.User;
import com.Drinker.recomendation.RecomendationKernel;
import com.Drinker.repository.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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


    @CrossOrigin(origins = "*")
    @PostMapping("/getQueue")
    public List<User> getQueue(@RequestBody String user) {
        RecomendationKernel recomendationKernel = new RecomendationKernel();
        JSONObject jsonUser = new JSONObject(user);
        Integer userId = jsonUser.getInt("id");
        User user1 = userRepo.findById(userId).get();
        List<User> users = userRepo.findAll();
        List<Integer> recomendationByDrink = recomendationKernel.getRecomendationByDrink(user1, users);

        List<User> recommendedUsers = new ArrayList<>();
        for (int i = 0; i < recomendationByDrink.size(); i++) {
            User u = userRepo.findById(recomendationByDrink.get(i)).get();
            recommendedUsers.add(u);
        }
        return recommendedUsers;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepo.findById(id).get();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/createUser")
    public User createUser(@RequestBody String newUser) {
        JSONObject jsonUser = new JSONObject(newUser);
        String firstName = (String) jsonUser.get("firstName");
        String secondName = (String) jsonUser.get("secondName");
        String phone = (String) jsonUser.get("phone");
        Integer age = jsonUser.getInt("age");
        ArrayList<Integer> alco = (ArrayList<Integer>) jsonUser.get("alco");
        ArrayList<Integer> interests = (ArrayList<Integer>) jsonUser.get("interest");
        ArrayList<Integer> places = (ArrayList<Integer>) jsonUser.get("place");


        User user = new User(firstName, secondName, phone, 5.0, "file", alco, interests, places);
        userRepo.save(user);
        return user;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/createGroup")
    public Group createGroup(@RequestBody String newGroup) {
        JSONObject jsonGroup = new JSONObject(newGroup);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(jsonGroup.getString("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String name = (String) jsonGroup.get("name");
        String comment = (String) jsonGroup.get("comment");
        Integer placeId = (Integer) jsonGroup.get("place");
        Place place = placeRepo.findById(placeId).get();

        Group group = new Group(date, name, comment, place);
        groupRepo.save(group);
        return group;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addToGroup")
    public void addUserToGroup(@RequestBody String groupAndUsers) {
        JSONObject jsonGroupAndUsers = new JSONObject(groupAndUsers);

        Integer groupId = (Integer) jsonGroupAndUsers.get("group");
        Group group = groupRepo.findById(groupId).get();

        JSONArray newUsers = jsonGroupAndUsers.getJSONArray("users");
        List<Object> newUsersList = newUsers.toList();

        List<Integer> usersInGroup = group.getUsers();

        for (int i = 0; i < newUsersList.size(); i++)
            usersInGroup.add((Integer) newUsersList.get(i));

        group.setUsers(usersInGroup);
        groupRepo.save(group);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/updateUser")
    public User updateUser(@RequestBody String newInfoUser) {
        JSONObject jsonUser = new JSONObject(newInfoUser);
        Integer userId = jsonUser.getInt("id");
        String firstName = (String) jsonUser.get("firstName");
        String secondName = (String) jsonUser.get("secondName");
        Integer age = jsonUser.getInt("age");
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

    @CrossOrigin(origins = "*")
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
        else
        {
            foundMatch.setMutual(true);
            matchRepo.save(foundMatch);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addPhoto")
    public void addPhotoToUser() {
    }


}
