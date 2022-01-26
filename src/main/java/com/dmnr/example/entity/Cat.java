package com.dmnr.example.entity;

import javax.persistence.Entity;

@Entity
public class Cat extends  Animal{

    public Cat() {
    }

    public Cat(String name) {
        super();
        this.setName(name);
    }

    @Override
    public String makeNoise() {
        return "meow meow";
    }
}
