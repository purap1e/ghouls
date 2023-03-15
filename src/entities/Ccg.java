package entities;

import enums.*;

public class Ccg extends Ghoul {

    private final double MULTIPLIER = 1.4;

    public Ccg(double power, double protection, double dexterity, double intelligence, Ranks rank) {
        super(power, protection, dexterity, intelligence, rank, Elements.AIR, Locations.MOUNTAINS);
    }

    @Override
    public double calculatePower() {
        return super.calculatePower() * MULTIPLIER;
    }
}
