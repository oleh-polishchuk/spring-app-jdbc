package com.geekhub.persistences;

import javax.persistence.Entity;

@Entity
public class Car {

    Integer id;
    String name;
    Integer wheelsId;
    Integer engineId;

    public Car() {}

    public Car(String name, Integer wheelsId, Integer engineId) {
        this.name = name;
        this.wheelsId = wheelsId;
        this.engineId = engineId;
    }

    public void startCar() {
        System.out.println("Start car ...");
//        engineId.start();
//        wheelsId.roll();
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

    public Integer getWheelsId() {
        return wheelsId;
    }

    public void setWheelsId(Integer wheelsId) {
        this.wheelsId = wheelsId;
    }

    public Integer getEngineId() {
        return engineId;
    }

    public void setEngineId(Integer engineId) {
        this.engineId = engineId;
    }
}
