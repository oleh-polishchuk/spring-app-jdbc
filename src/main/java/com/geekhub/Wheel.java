package com.geekhub;

public class Wheel {

    public Tyres tyres;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public void roll() {
        System.out.println("Start roll " + tyres.size + " wheels named " + tyres.name + ".");
    }
}
