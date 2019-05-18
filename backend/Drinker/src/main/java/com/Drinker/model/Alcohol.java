package com.Drinker.model;

import javax.persistence.*;

@Entity
@Table(name = "alcohol", schema = "public")
public class Alcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer vol;

    public Alcohol() {
    }

    public Alcohol(String name, Integer vol) {
        this.name = name;
        this.vol = vol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
