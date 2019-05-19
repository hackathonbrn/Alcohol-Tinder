package com.Drinker.model;

import javax.persistence.*;

@Entity
@Table(name = "place", schema = "public")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String geo;

    public Place() {
    }

    public Place(String name, String geo) {
        this.name = name;
        this.geo = geo;
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

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }
}
