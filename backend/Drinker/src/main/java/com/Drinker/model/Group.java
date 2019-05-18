package com.Drinker.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "group", schema = "public")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private String name;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeid")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Place place;

//    @ElementCollection
//    @CollectionTable(name = "useringroup", joinColumns = @JoinColumn(name = "groupid"))
//    @Column(name = "userid")
//    private List<Integer> users;

    public Group() {
    }

//    public Group(Date date, String name, String comment, Place place, List<Integer> users) {
//        this.date = date;
//        this.name = name;
//        this.comment = comment;
//        this.place = place;
//        this.users = users;
//    }

    public Group(Date date, String name, String comment, Place place) {
        this.date = date;
        this.name = name;
        this.comment = comment;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

//    public List<Integer> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<Integer> users) {
//        this.users = users;
//    }
}
