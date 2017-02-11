package com.geekhub;

public class Car {

    Wheel wheels;
    Engine engine;

    public Car(Wheel wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("Start car ...");
        engine.start();
        wheels.roll();
    }
}
