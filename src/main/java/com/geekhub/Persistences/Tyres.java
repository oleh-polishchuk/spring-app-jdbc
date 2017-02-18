package com.geekhub.persistences;

import javax.persistence.Entity;

@Entity
public class Tyres {

    public String name;
    public Integer size;

    public Tyres(String name, Integer size) {
        this.name = name;
        this.size = size;
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
