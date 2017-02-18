package com.geekhub.persistences;

import javax.persistence.Entity;

@Entity
public class Wheel {

    public Tyres tyres;

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public void roll() {
        System.out.println("Start roll " + tyres.size + " wheels named " + tyres.name + ".");
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
