package services;

import entities.*;

import java.util.*;

public interface Service {
    List<Ghoul> getAll();
    void save(Ghoul ghoul);
    void remove(int index);
    Ghoul get(int index);
}
