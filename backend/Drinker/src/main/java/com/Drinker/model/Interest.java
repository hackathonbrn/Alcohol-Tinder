package com.Drinker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "interest", schema = "public")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "interests")
    List<User> users;

    public Interest() {
    }

    public Interest(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
