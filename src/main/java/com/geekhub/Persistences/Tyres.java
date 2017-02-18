package com.geekhub.persistences;

import javax.persistence.Entity;

@Entity
public class Tyres {

    public Integer id;
    public String name;
    public Integer size;

    public Tyres() {}

    public Tyres(String name, Integer size) {
        this.name = name;
        this.size = size;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
