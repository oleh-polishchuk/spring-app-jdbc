package com.geekhub.persistences;

import javax.persistence.Entity;

@Entity
public class Engine {

    Double engineCapacity;

    public Engine(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void start() {
        System.out.println("Start engine with capacity: " + engineCapacity.toString() + " litre.");
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
