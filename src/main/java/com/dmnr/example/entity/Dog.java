package com.dmnr.example.entity;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

    public Dog() {
    }

    public Dog(String name) {
        super();
        this.setName(name);
    }

    @Override
    public String makeNoise() {
        return "woof woof";
    }
}
