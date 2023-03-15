package entities;

import enums.*;

public class Aogiri extends Ghoul {

    private final double MULTIPLIER = 1.5;

    public Aogiri(double power, double protection, double dexterity, double intelligence, Ranks rank) {
        super(power, protection, dexterity, intelligence, rank, Elements.FIRE, Locations.VILLAGE);
    }

    @Override
    public double calculatePower() {
        return super.calculatePower() * MULTIPLIER;
    }
}
