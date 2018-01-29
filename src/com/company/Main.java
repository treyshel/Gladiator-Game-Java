package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Main {

    public static String get_choice(Gladiator glad_name) {
        String attacker_choice;
        Scanner choice_input = new Scanner(System.in);
        while (true) {
            System.out.println("Gladiator" + " " + glad_name.name + " " + "|HP" + glad_name.health + "| |RAGE" + glad_name.rage + "| |LowDamage" + glad_name.low_damage + "| |HighDamage" + glad_name.high_damage + "|\n[A]ttack\n[H]eal");
            attacker_choice = choice_input.next().toUpperCase();
            if (attacker_choice.equals("A")) {
                return "A";
            } else if (attacker_choice.equals("H")) {
                return "H";
            } else {
                System.out.println("INVALID CHOICE");
            }
        }
    }

    public static void battle(Gladiator attacker, Gladiator defender, String choice) {
        if (choice.equals("A")) {
            attacker.attack(defender);
        } else if (choice.equals("H")) {
            attacker.heal();
        }
    }

    public static void main(String[] args) {
        String Glad1_name;
        Scanner user_input = new Scanner(System.in);
        System.out.println("Gladiator 1 -> Name: ");
        Glad1_name = user_input.next();
        Gladiator Glad1 = new Gladiator(Glad1_name);

        String Glad2_name;
        Scanner user_input2 = new Scanner(System.in);
        System.out.println("Gladiator 2 -> Name: ");
        Glad2_name = user_input2.next();
        Gladiator Glad2 = new Gladiator(Glad2_name);

        while (true) {
            if (!Glad1.isDead()) {
                String choice = get_choice(Glad1);
                battle(Glad1, Glad2, choice);
                if (Glad2.isDead()) {
                    System.out.println("Gladiator" + Glad1_name + "WINS!!");
                    break;
                }
            }
            if (!Glad2.isDead()) {
                String choice = get_choice(Glad2);
                battle(Glad2, Glad1, choice);
                if (Glad1.isDead()) {
                    System.out.println("Gladiator" + Glad2_name + "WINS!!");
                    break;
                }
            }
        }
    }
}
