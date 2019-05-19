package com.Drinker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alcohol", schema = "public")
public class Alcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer vol;

    @ManyToMany(mappedBy = "alcohol")
    List<User> users;

    public Alcohol() {
    }

    public Alcohol(String name, Integer vol) {
        this.name = name;
        this.vol = vol;
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

    public Integer getVol() {
        return vol;
    }

    public void setVol(Integer vol) {
        this.vol = vol;
    }
}
