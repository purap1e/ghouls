import db.*;
import entities.*;
import enums.*;
import services.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final Service service = new Database();

        boolean process = true;
        while (process) {
            System.out.println("enter 1 for 1v1 combat");
            System.out.println("enter 2 for tournament");
            System.out.println("enter 0 to exit");
            int num = sc.nextInt();

            switch (num) {
                case 1 -> {
                    getAll();
                    System.out.println("enter the numbers of 2 fighters");
                    int ghoul_1 = sc.nextInt();
                    int ghoul_2 = sc.nextInt();

                    printForLocation();

                    int locationNum = sc.nextInt();
                    Locations location = getLocation(locationNum);
                    if (location == null) {
                        System.out.println("Please try again");
                        continue;
                    }
                    System.out.println("The winner is ghoul: " + fight(service.get(ghoul_1), service.get(ghoul_2), location));
                }
                case 2 -> {
                    getAll();
                    System.out.println("select 4 participants for the tournament");

                    Set<Integer> participants = new HashSet<>();
                    while (participants.size() != 4) {
                        int participant = sc.nextInt();
                        participants.add(participant);

                        int size = participants.size();
                        System.out.println(String.format("Please enter '%s' more participant(s)", 4 - size));
                    }
                    List<Integer> list = new ArrayList<>(participants);

                    printForLocation();
                    int locationNum = sc.nextInt();
                    Locations location = getLocation(locationNum);
                    if (location == null) {
                        System.out.println("Please try again");
                        continue;
                    }
                    
                    List<Ghoul> winners = new ArrayList<>();
                    for (int i = 0; i < participants.size() / 2; i++) {
                        winners.add(fight(service.get(list.get(i)),service.get(list.get(i + 2)), location));
                    }

                    System.out.println("Ghoul " + winners.get(0) + " and " + "Ghoul " + winners.get(1));
                    System.out.println("The winner is ghoul: " + fight(winners.get(0), winners.get(1), location));
                }
                case 0 -> {
                    process = false;
                }
            }
        }
    }
    
    public static void printForLocation() {
        System.out.println("enter the location of the fight");
        System.out.println("1 " + Locations.CITY);
        System.out.println("2 " + Locations.MOUNTAINS);
        System.out.println("3 " + Locations.VILLAGE);
    }

    public static Locations getLocation(int locationNum) {
        return switch (locationNum) {
            case 1 -> Locations.CITY;
            case 2 -> Locations.MOUNTAINS;
            case 3 -> Locations.VILLAGE;
            default -> null;
        };
    }

    public static void getAll() {
        for (int i = 0; i < Database.ghoulList.size(); i++) {
            System.out.println(i + " " + Database.ghoulList.get(i));
        }
    }
    public static Ghoul fight(Ghoul g1, Ghoul g2, Locations location) {
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
