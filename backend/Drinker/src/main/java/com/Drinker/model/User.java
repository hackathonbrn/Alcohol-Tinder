package com.Drinker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "phonenumber")
    private String phone;

    private Double rating;

    private String photo;

    private Integer age;

//    @ElementCollection
//    @CollectionTable(name = "useralcohol", joinColumns = @JoinColumn(name = "userid"))
//    @Column(name = "alcoholid")
//    private List<Integer> alcohol;

//    @ElementCollection
//    @CollectionTable(name = "userinterest", joinColumns = @JoinColumn(name = "userid"))
//    @Column(name = "alcohointerestlid")
//    private List<Integer> interests;

//    @ElementCollection
//    @CollectionTable(name = "userplace", joinColumns = @JoinColumn(name = "userid"))
//    @Column(name = "placeid")
//    private List<Integer> places;

    @ManyToMany
    @JoinTable(
            name = "useralcohol",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "alcoholid")
    )
    private List<Alcohol> alcohol;

    @ManyToMany
    @JoinTable(
            name = "userinterest",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "inerestid")
    )
    private List<Interest> interests;

    @ManyToMany
    @JoinTable(
            name = "userplace",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "placeid")
    )
    private List<Place> places;

    public User() {
    }

    public User(String firstName, String secondName, String phone, Double rating, String photo, List<Alcohol> alcohol, List<Interest> interests, List<Place> places) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.rating = rating;
        this.photo = photo;
        this.alcohol = alcohol;
        this.interests = interests;
        this.places = places;
    }

    public User(String firstName, String secondName, String phone, Double rating, String photo, Integer age, List<Alcohol> alcohol, List<Interest> interests, List<Place> places) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.rating = rating;
        this.photo = photo;
        this.age = age;
        this.alcohol = alcohol;
        this.interests = interests;
        this.places = places;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Alcohol> getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(List<Alcohol> alcohol) {
        this.alcohol = alcohol;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Integer> getAlcoholListIds() {
        List<Integer> ids = new ArrayList<>();

        for (Alcohol a: this.alcohol) {
            ids.add(a.getId());
        }
        return ids;
    }
}
