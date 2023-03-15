package entities;

import enums.*;

public class Anteika extends Ghoul {

    private final double MULTIPLIER = 1.3;

    public Anteika(double power, double protection, double dexterity, double intelligence, Ranks rank) {
        super(power, protection, dexterity, intelligence, rank, Elements.WATER, Locations.CITY);
    }

    @Override
    public double calculatePower() {
        return super.calculatePower() * MULTIPLIER;
    }
}
