package com.Drinker.controller;

import com.Drinker.model.*;
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

    @Autowired
    private InterestRepo interestRepo;

    /**
     * Получение списка рекомендованных пользователей
     * @param user - id пользователя, для которого составляется рекомендация
     */
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

    /**
     * Получение информации о пользователе
     * @param id - id пользователя
     * @return информация о пользователе
     */
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

        User user = new User(firstName, secondName, phone, 5.0, "file", age, alco, interests, places);
        userRepo.save(user);
        return user;
    }

    /**
     * Создание группы
     * @param newGroup - информация о создаваемой группе
     * @return новая группа
     */
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

    /**
     * Добавление пользователей в группу
     * @param groupAndUsers - id группы и id пользователей
     */
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

    /**
     * Обновление информации о пользователе
     * @param newInfoUser - новая информация о пользователе
     * @return обновленного пользователя
     */
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
        user.setAge(age);

        userRepo.save(user);
        return user;
    }

    /**
     * Просталение лайка, проверка на совпадение пользователей
     * @param userPair - пара пользователей, между которыми образовалась связь
     */
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

    /**
     * Возращает список алкогольных напитков
     * @return список алкогольных напитков
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/getAlcoList")
    public List<Alcohol> getAllAlcohol() {
        return alcoholRepo.findAll();
    }

    /**
     * Получение всех совпадений для конкретного пользователя
     * @param user - пользователь
     * @return все совпадения
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/getUserMatches")
    public List<User> getUserMatches(@RequestBody String user) {
        JSONObject jsonUser = new JSONObject(user);
        Integer userId = jsonUser.getInt("id");

        User currentUser = userRepo.findById(userId).get();
        List<Match> user1 = matchRepo.findByUser1AndMutualIsTrue(currentUser);
        List<Match> user2 = matchRepo.findByUser2AndMutualIsTrue(currentUser);
        List<User> result = new ArrayList<>();

        for (int i = 0; i < user1.size(); i++)
            result.add(user1.get(i).getUser2());

        for (int i = 0; i < user2.size(); i++)
            result.add(user2.get(i).getUser1());

        return result;
    }

    /**
     * Получение информации об алкогольных напитках, которые предпочитает пользователь
     * @param user - пользователь
     * @return алкогольные напитки пользователя
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/getUserAlcoList")
    public List<Alcohol> getUserAlco(@RequestBody String user) {
        JSONObject jsonUser = new JSONObject(user);
        Integer userId = jsonUser.getInt("id");

        User currentUser = userRepo.findById(userId).get();

        List<Integer> userAlcohol = currentUser.getAlcohol();
        List<Alcohol> result = new ArrayList<>();

        for (int i = 0; i < userAlcohol.size(); i++) {
            result.add(alcoholRepo.findById(userAlcohol.get(i)).get());
        }

        return result;
    }

    /**
     * Получение информации об интересах пользователя
     * @param user - пользователь
     * @return список интересов пользователя
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/getUserInterestList")
    public List<Interest> getUserInterest(@RequestBody String user) {
        JSONObject jsonUser = new JSONObject(user);
        Integer userId = jsonUser.getInt("id");

        User currentUser = userRepo.findById(userId).get();

        List<Integer> userInterest = currentUser.getInterests();
        List<Interest> result = new ArrayList<>();

        for (int i = 0; i < userInterest.size(); i++)
            result.add(interestRepo.findById(userInterest.get(i)).get());


        return result;
    }

    /**
     * Получение информации о местах, которые любит посещать пользователь
     * @param user - пользователь
     * @return список мест пользователя
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/getUserPlaceList")
    public List<Place> getUserPlaces(@RequestBody String user) {
        JSONObject jsonUser = new JSONObject(user);
        Integer userId = jsonUser.getInt("id");

        User currentUser = userRepo.findById(userId).get();

        List<Integer> userPlaces = currentUser.getPlaces();
        List<Place> result = new ArrayList<>();

        for (int i = 0; i < userPlaces.size(); i++)
            result.add(placeRepo.findById(userPlaces.get(i)).get());


        return result;
    }
}
