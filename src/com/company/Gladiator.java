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
        this.name = name;
        health = 150;
        rage = 0;
        /*rand.nextInt((max - min) + 1) + min;*/
        low_damage = rand.nextInt((10 - 1) + 1) + 1;
        high_damage = rand.nextInt((30 - 20) + 1) + 20;
    }

    public void attack(Gladiator defender) {
        /*line 29: damage is going to be a random integer
        choosing between the high and low damage*/
        int random_damage = rand.nextInt(high_damage) + low_damage;
        /*//lines 32-33: if the randomly generated damage is below the amount
        of rage the attacker has, the damage will be doubled to the opponent*/
        if (rand.nextInt((100 - 1) + 1) + 1 <= rage) {
            defender.health -= (2 * random_damage);
            rage = 0;
            System.out.println("CRITCAL HIT OF " + random_damage * 2 + "\n");
        } else {
            /*lines 38-39: if the random number isn't below the attacker's rage,
            the damage will just be the randomly generated number and rage will go up*/
            defender.health -= random_damage;
            rage += 15;
            System.out.println("HIT OF " + random_damage + "\n");
            //this keeps from the losing opponent's health from going below 0
            defender.health = Math.max(0, defender.health);
        }
    }

    public void heal() {
        health += 15;
    }

    public boolean isDead() {
        if (health == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String name() {
        return this.name;
    }
}