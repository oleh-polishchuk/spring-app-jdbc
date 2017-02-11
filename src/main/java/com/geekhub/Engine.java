package com.geekhub;

public class Engine {

    Double engineCapacity;

    public Engine(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void start() {
        System.out.println("Start engine with capacity: " + engineCapacity.toString() + " litre.");
    }
}
