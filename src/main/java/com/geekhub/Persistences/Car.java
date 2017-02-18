package com.geekhub.persistences;

import javax.persistence.Entity;

@Entity
public class Car {

    Integer id;
    Wheel wheels;
    Engine engine;

    public Car() {}

    public Car(Wheel wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("Start car ...");
        engine.start();
        wheels.roll();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Wheel getWheels() {
        return wheels;
    }

    public void setWheels(Wheel wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
