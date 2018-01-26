package com.company;

import java.util.Random;

public class Gladiator {

    //like __init__ in python
    public String name;
    public Integer health;
    public Integer rage;
    public Integer low_damage;
    public Integer high_damage;


    Random rand = new Random();

    Gladiator(String name) {
        name = name;
        health = 150;
        rage = 0;
        /*rand.nextInt((max - min) + 1) + min;*/
        low_damage = rand.nextInt((10 - 1) + 1) + 1;
        high_damage = rand.nextInt((30 - 20) + 1) + 20;
    }

    
}