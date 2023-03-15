package entities;

import enums.*;

public class Ghoul {
    public static double RANK_S = 1.5;
    public static double RANK_SS = 2.5;
    public static double RANK_SSS = 3.5;
    private double power;
    private double protection;
    private double dexterity;
    private double intelligence;
    private Ranks rank;
    private Elements element;
    private Locations location;

    public Ghoul() {
    }

    public Ghoul(double power, double protection, double dexterity, double intelligence, Ranks rank, Elements element, Locations location) {
        this.power = power;
        this.protection = protection;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.rank = rank;
        this.element = element;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Ghoul{" +
                "power=" + power +
                ", protection=" + protection +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", rank=" + rank +
                ", element=" + element +
                ", location=" + location +
                '}';
    }

    public double calculatePower() {
        switch (getRank()) {
            case S -> {
                return (getPower() * getDexterity() + getProtection() * getIntelligence()) * Ghoul.RANK_S;
            }
            case SS -> {
                return (getPower() * getDexterity() + getProtection() * getIntelligence()) * Ghoul.RANK_SS;
            }
            case SSS -> {
                return (getPower() * getDexterity() + getProtection() * getIntelligence()) * Ghoul.RANK_SSS;
            }
        }
        return 0;
    };

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }

    public Elements getElement() {
        return element;
    }

    public void setElement(Elements element) {
        this.element = element;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}
