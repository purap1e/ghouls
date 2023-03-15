package services.impl;

import db.*;
import entities.*;
import enums.*;
import services.*;

public class GhoulServiceImpl implements GhoulService {
    @Override
    public void printForLocation() {
        System.out.println("enter the location of the fight");
        System.out.println("1 " + Locations.CITY);
        System.out.println("2 " + Locations.MOUNTAINS);
        System.out.println("3 " + Locations.VILLAGE);
    }

    @Override
    public Locations getLocation(int locationNum) {
        return switch (locationNum) {
            case 1 -> Locations.CITY;
            case 2 -> Locations.MOUNTAINS;
            case 3 -> Locations.VILLAGE;
            default -> null;
        };
    }

    @Override
    public void getAll() {
        for (int i = 0; i < Database.ghoulList.size(); i++) {
            System.out.println(i + " " + Database.ghoulList.get(i));
        }
    }

    @Override
    public Ghoul fight(Ghoul g1, Ghoul g2, Locations location) {
        double multiplier = 1.3;

        System.out.println(g1 + " and " + g2 + " are fighting");

        double powerOfGhoul1 = g1.getPower();
        double powerOfGhoul2 = g2.getPower();

        if (g1.getLocation().equals(location) && !g2.getLocation().equals(location)) {
            if (powerOfGhoul1 * multiplier < powerOfGhoul2) {
                return g2;
            } else {
                return g1;
            }
        }  else if (!g1.getLocation().equals(location) && g2.getLocation().equals(location)) {
            if (powerOfGhoul1 < powerOfGhoul2 * multiplier) {
                return g2;
            } else {
                return g1;
            }
        }
        if (powerOfGhoul1 < powerOfGhoul2) {
            return g2;
        } else {
            return g1;
        }
    }
}
