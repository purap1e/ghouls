package services;

import entities.*;
import enums.*;

public interface GhoulService {
    void printForLocation();
    Locations getLocation(int locationNum);
    void getAll();
    Ghoul fight(Ghoul g1, Ghoul g2, Locations location);
}
