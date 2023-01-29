package it.unimol.app;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String surname;
    private int dtn;
    private String nationlity;
    private int number;
    private int attack;
    private int defence;
    private int speed;
    private int strenght;

    public Player(String name, String surname, int dtn, String nationality, int number, int attack, int defence, int speed, int strenght) {
        this.name = name;
        this.surname = surname;
        this.dtn = dtn;
        this.nationlity = nationality;
        this.number = number;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.strenght = strenght;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }

    public double getPoints() {
        int temp = (this.attack + this.defence + this.speed + this.strenght) / 4;

        return temp / (2022 - dtn);
    }

    public int getDtn() {
        return dtn;
    }

    public String getNationlity() {
        return nationlity;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrenght() {
        return strenght;
    }
    
}
