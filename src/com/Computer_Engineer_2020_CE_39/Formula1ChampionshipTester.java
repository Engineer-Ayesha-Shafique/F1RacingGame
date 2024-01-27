package com.Computer_Engineer_2020_CE_39;

import java.text.ParseException;
import java.util.Scanner;
public class Formula1ChampionshipTester {
    public static void main(String[] args) throws ParseException {
        Formula1ChampionshipManager fcm1 = new Formula1ChampionshipManager(10, 10);
        System.out.println("---------Welcome to FORMULA 1 Championship 2022---------");
        Scanner input = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("\n----Please use the following menu to do your changes----");
                    System.out.println("" +
                              "'ADD'          --->    Create a new driver" +
                            "\n'DEL'          --->    Delete a driver" +
                            "\n'CHANGE'       --->    Change Driver Name OF Specific Team   "+
                            "\n'SORT_POINTS'  --->    Display Table(Sorted in Asecnding order w.r.t to points)" +
                            "\n'SORT_FP'      --->    Display Table(Sorted in Asecnding order w.r.t to 1st Position)" +
                            "\n'STATS'        --->    Display the Statistics of Championship" +
                            "\n'STATS_TABLE'  --->    Display Table(Sorted w.r.t points and points w.r.t position if same points in descending)" +
                            "\n'ADD_RACE'     --->    Add a race"+
                                                        "\n'DATA'         --->    Get Complete Data of all drivers"+
                            "\n'ADDRANDRACE'  --->    Add a random race"+
                            "\n'SEARCH'       --->    Search races a driver particpated with it's name" +
                            "\n'SAVE_DATA'    --->    Save information to a file" +
                            "\n'RECOVER_DATA' --->    Recover information from file"+
                            "\n'QUIT'         --->    Exit Program");
            System.out.println("\nPlease enter an option:");userInput = input.next();
            userInput = userInput.toUpperCase();
            if (userInput.equals("ADD")) {fcm1.createNewDriver();
            } else if (userInput.equals("DEL")) {fcm1.deleteDriver();
            } else if (userInput.equals("CHANGE")) {fcm1.changeDriver();
            } else if (userInput.equals("SORT_FP")) {fcm1.sortFp();
            } else if (userInput.equals("SORT_POINTS")) {fcm1.SortPoints();
            } else if (userInput.equals("STATS")) {fcm1.displayStats();
            } else if (userInput.equals("STATS_TABLE")) {fcm1.displayTable();
            } else if (userInput.equals("DATA")) {fcm1.completeData();
            } else if (userInput.equals("ADD_RACE")) {fcm1.addRace();
            } else if (userInput.equals("ADDRANDRACE")) {fcm1.addRandRace();
            } else if (userInput.equals("SEARCH")) {fcm1.search();
            } else if (userInput.equals("SAVE_DATA")) {fcm1.saveInfo();
            } else if (userInput.equals("RECOVER_DATA")) {fcm1.recoverInfo();
            } else if (userInput.equals("QUIT")){
                System.out.println("Thank you for using this Formula 1 Championship Manager. Have a nice day!");
                System.exit(0);
            }
        } while (true);
    }
}