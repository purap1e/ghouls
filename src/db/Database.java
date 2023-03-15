package db;

import entities.*;
import enums.*;
import services.*;

import java.util.*;

public class Database implements DbService {
    public static List<Ghoul> ghoulList = new ArrayList<>();
    static {
        ghoulList.add(new Anteika(3.2, 5.2, 4.4, 6, Ranks.SS));
        ghoulList.add(new Anteika(3.2, 5.2, 4.4, 6, Ranks.SSS));
        ghoulList.add(new Anteika(3.2, 5.2, 4.4, 6, Ranks.S));
        ghoulList.add(new Ccg(1.2, 9.4, 6.2, 5.1, Ranks.SSS));
        ghoulList.add(new Ccg(7.4, 3.2, 5.1, 3.7, Ranks.SS));
        ghoulList.add(new Ccg(10, 1.2, 3.6, 7.4, Ranks.S));
        ghoulList.add(new Aogiri(2.8, 5.2, 4.8, 3.6, Ranks.SS));
        ghoulList.add(new Aogiri(5.4, 5.2, 2.4, 5.1, Ranks.SSS));
        ghoulList.add(new Aogiri(4.6, 9.1, 8.2, 4.6, Ranks.SS));
    }

    @Override
    public Ghoul get(int index) {
        return ghoulList.get(index);
    }

    @Override
    public List<Ghoul> getAll() {
        return ghoulList;
    }

    @Override
    public void save(Ghoul ghoul) {
        ghoulList.add(ghoul);
    }

    @Override
    public void remove(int index) {
        ghoulList.remove(index);
    }
}
