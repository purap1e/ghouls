import db.*;
import entities.*;
import enums.*;
import services.*;
import services.impl.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final DbService dbService = new Database();
        final GhoulService ghoulService = new GhoulServiceImpl();

        boolean process = true;
        while (process) {
            System.out.println("enter 1 for 1v1 combat");
            System.out.println("enter 2 for tournament");
            System.out.println("enter 0 to exit");
            int num = sc.nextInt();

            switch (num) {
                case 1 -> {
                    ghoulService.getAll();
                    System.out.println("enter the numbers of 2 fighters");
                    int ghoul_1 = sc.nextInt();
                    int ghoul_2 = sc.nextInt();

                    ghoulService.printForLocation();

                    int locationNum = sc.nextInt();
                    Locations location = ghoulService.getLocation(locationNum);
                    if (location == null) {
                        System.out.println("Please try again");
                        continue;
                    }
                    System.out.println("The winner is ghoul: " + ghoulService.fight(dbService.get(ghoul_1), dbService.get(ghoul_2), location));
                }
                case 2 -> {
                    ghoulService.getAll();
                    System.out.println("select 4 participants for the tournament");

                    Set<Integer> participants = new HashSet<>();
                    while (participants.size() != 4) {
                        int participant = sc.nextInt();
                        participants.add(participant);

                        int size = participants.size();
                        System.out.println(String.format("Please enter '%s' more participant(s)", 4 - size));
                    }
                    List<Integer> list = new ArrayList<>(participants);

                    ghoulService.printForLocation();
                    int locationNum = sc.nextInt();
                    Locations location = ghoulService.getLocation(locationNum);
                    if (location == null) {
                        System.out.println("Please try again");
                        continue;
                    }
                    
                    List<Ghoul> winners = new ArrayList<>();
                    for (int i = 0; i < participants.size() / 2; i++) {
                        winners.add(ghoulService.fight(dbService.get(list.get(i)), dbService.get(list.get(i + 2)), location));
                    }

                    System.out.println("Ghoul " + winners.get(0) + " and " + "Ghoul " + winners.get(1));
                    System.out.println("The winner is ghoul: " + ghoulService.fight(winners.get(0), winners.get(1), location));
                }
                case 0 -> {
                    process = false;
                }
            }
        }
    }
}
