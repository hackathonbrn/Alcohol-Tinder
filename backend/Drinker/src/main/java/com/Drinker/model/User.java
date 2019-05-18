package com.Drinker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "phonenumber")
    private String phone;

    private Double rating;

    private String photo;

    @ElementCollection
    @CollectionTable(name = "useralcohol", joinColumns = @JoinColumn(name = "userid"))
    @Column(name = "alcoholid")
    private List<Integer> alcohol;

//    @ElementCollection
//    @CollectionTable(name = "userinterest", joinColumns = @JoinColumn(name = "userid"))
//    @Column(name = "alcohointerestlid")
//    private List<Integer> interests;
//
//    @ElementCollection
//    @CollectionTable(name = "userplace", joinColumns = @JoinColumn(name = "userid"))
//    @Column(name = "placeid")
//    private List<Integer> places;

    public User() {
    }

//    public User(String firstName, String secondName, String phone, Double rating, String photo, List<Integer> alcohol, List<Integer> interests, List<Integer> places) {
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.phone = phone;
//        this.rating = rating;
//        this.photo = photo;
//        this.alcohol = alcohol;
//        this.interests = interests;
//        this.places = places;
//    }

    public User(String firstName, String secondName, String phone, Double rating, String photo, List<Integer> alcohol) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.rating = rating;
        this.photo = photo;
        this.alcohol = alcohol;
    }

    public User(String firstName, String secondName, String phone, Double rating, String photo) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.rating = rating;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Integer> getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(List<Integer> alcohol) {
        this.alcohol = alcohol;
    }

//    public List<Integer> getInterests() {
//        return interests;
//    }
//
//    public void setInterests(List<Integer> interests) {
//        this.interests = interests;
//    }
//
//    public List<Integer> getPlaces() {
//        return places;
//    }
//
//    public void setPlaces(List<Integer> places) {
//        this.places = places;
//    }
}
