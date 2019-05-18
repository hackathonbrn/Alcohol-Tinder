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

    @Column(name = "phone")
    private String phone;

    private Double rating;

    private String photo;

    @ElementCollection(targetClass = Alcohol.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "useralcohol", joinColumns = @JoinColumn(name = "alcoholid"))
    private List<User> alcohol;


    public User() {
    }

    public User(String firstName, String secondName, String phone, Double rating, String photo, List<User> alcohol) {
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

    public List<User> getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(List<User> alcohol) {
        this.alcohol = alcohol;
    }
}
