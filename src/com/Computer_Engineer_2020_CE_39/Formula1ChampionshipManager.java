package com.Computer_Engineer_2020_CE_39;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;


public class Formula1ChampionshipManager extends Formula1Driver implements ChampionshipManager {
    private int f1drivers;
    private final int f1cars;
    private String raceDate;
    String dataofraces = "";
    Scanner input = new Scanner(System.in);
    static ArrayList<Formula1Driver> driverList = new ArrayList<Formula1Driver>();

    public void getDriverList() {
    }
    public Formula1ChampionshipManager(int f1drivers, int f1cars) {
        super();
        this.f1drivers = f1drivers;
        this.f1cars = f1cars;
    }

    @Override
    public int getf1drivers() {
        return 0;
    }
    @Override
    public int getf1cars() {
        return 0;
    }
    public void createNewDriver() {
        System.out.println("Enter the new driver's name: ");super.setDriverName(input.nextLine());
        System.out.println("Enter " + super.getDriverName() + "'s team name: ");super.setDriverTeam(input.nextLine());
        System.out.println("Enter " + super.getDriverName() + "'s country: ");super.setDriverLocation(input.nextLine());
        Formula1Driver newDriver = new Formula1Driver(getDriverName(), getDriverLocation(), getDriverTeam(),
                getPositionNo1(), getPositionNo2(), getPositionNo3(),
                getTotalPoints(), getRaces());
        driverList.add(newDriver);
        System.out.println(newDriver.getDriverName() + " has been added to this F1 Championship!");
        for (Formula1Driver driver : driverList) {
            System.out.println(driver.toString());
        }
    }
    public void deleteDriver() {
        System.out.println("Enter the name of the driver you want to delete: ");
        String deletingDriver = input.next();
        driverList.removeIf(driver -> deletingDriver.equals(driver.getDriverName()));
        System.out.println(deletingDriver + " has been deleted!");
    }
    public void changeDriver() {
        System.out.println("Enter the team you wish to change the driver for: ");
        String changingTeam = input.next();
        for (Formula1Driver driver : driverList) {
            if (changingTeam.equals(driver.getDriverTeam())) {
                System.out.println("Enter the name of the new driver: ");
                String newDriver = input.next();
                driver.setDriverName(newDriver);
            }
        }
        System.out.println("The racer for " + changingTeam + " has been changed!");
    }
    public void displayStats() {
        System.out.println("Enter the name of the driver you wish to see the statistics for: ");
        String statDriver = input.next();
        for (Formula1Driver driver : driverList) {
            if (statDriver.equals(driver.getDriverName())) {
                System.out.println("Races participated this season: " + driver.getRaces() +
                        "\nNumber of first positions: " + driver.getPositionNo1() +
                        "\nNumber of second positions: " + driver.getPositionNo2() +
                        "\nNumber of third positions: " + driver.getPositionNo3() +
                        "\nTotal number of points: " + driver.getTotalPoints()+
                        "\n");
            }
        }
    }
    public void displayTable() {
        driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getPositionNo1()-s1.getPositionNo1());
        driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getTotalPoints()-s1.getTotalPoints());
        System.out.println("Formula 1 Championship 2022 Stats table");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s", "DRIVER", "|", "LOCATION", "|", "TEAM", "|", "POINTS", "|", "1ST POSITIONS", "|",
                "RACES");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for (Formula1Driver driver : driverList) {
            System.out.format("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s",
                    driver.getDriverName(), "|", driver.getDriverLocation(), "|", driver.getDriverTeam(), "|",
                    driver.getTotalPoints(), "|", driver.getPositionNo1(), "|", driver.getRaces() + "\n");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
    public void addRace() {
        int size = driverList.size();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter date (Format : dd/MM/yyyy) of new race: ");raceDate = input.nextLine();
        try {
            Date date1 = format.parse(raceDate);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("The new race has been added!");
        ArrayList<Integer> list = new ArrayList<>(size);
        for(int i = 1; i <= size; i++) {list.add(i);}
        for (Formula1Driver driver : driverList) {
            driver.raceDateList.add(raceDate);
            Random rand = new Random();
            int index = rand.nextInt(list.size());
            int element = list.get(index);
            list.remove(index);
            int currentPoints;
            switch (element) {
                case 1 -> {
                    driver.setPointsPerRace(25);
                    driver.setPositionNo1();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("1");

                }
                case 2 -> {
                    driver.setPointsPerRace(18);
                    driver.setPositionNo2();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("2");

                }
                case 3 -> {

                    driver.setPointsPerRace(15);

                    driver.setPositionNo3();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("3");

                }
                case 4 -> {

                    driver.setPointsPerRace(12);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("4");

                }

                case 5 -> {


                    driver.setPointsPerRace(10);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("5");

                }
                case 6 -> {


                    driver.setPointsPerRace(8);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("6");

                }
                case 7 -> {


                    driver.setPointsPerRace(6);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("7");

                }
                case 8 -> {


                    driver.setPointsPerRace(4);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("8");

                }
                case 9 -> {


                    driver.setPointsPerRace(2);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("9");

                }
                case 10 -> {

                    driver.setPointsPerRace(1);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("10");

                }
            }

        }
    }
    public void addRaceGui(String raceDate) {
        int size = driverList.size();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = format.parse(raceDate);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("The new race has been added!");
        ArrayList<Integer> list = new ArrayList<>(size);
        for(int i = 1; i <= size; i++) {list.add(i);}
        for (Formula1Driver driver : driverList) {
            driver.raceDateList.add(raceDate);
            Random rand = new Random();
            int index = rand.nextInt(list.size());
            int element = list.get(index);
            list.remove(index);
            int currentPoints;
            switch (element) {
                case 1 -> {
                    driver.setPointsPerRace(25);
                    driver.setPositionNo1();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("1");

                }
                case 2 -> {
                    driver.setPointsPerRace(18);
                    driver.setPositionNo2();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("2");

                }
                case 3 -> {

                    driver.setPointsPerRace(15);

                    driver.setPositionNo3();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("3");

                }
                case 4 -> {

                    driver.setPointsPerRace(12);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("4");

                }

                case 5 -> {


                    driver.setPointsPerRace(10);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("5");

                }
                case 6 -> {


                    driver.setPointsPerRace(8);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("6");

                }
                case 7 -> {


                    driver.setPointsPerRace(6);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("7");

                }
                case 8 -> {


                    driver.setPointsPerRace(4);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("8");

                }
                case 9 -> {


                    driver.setPointsPerRace(2);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("9");

                }
                case 10 -> {

                    driver.setPointsPerRace(1);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("10");

                }
            }

        }
    }
    public void addRandRace() throws ParseException {
        int size = driverList.size();
        Random rando = new Random();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date dateFrom = dateFormat.parse("2022");
        long timestampFrom = dateFrom.getTime();
        Date dateTo = dateFormat.parse("2023");
        long timestampTo = dateTo.getTime();
        long timeRange = timestampTo - timestampFrom;
        long randomTimestamp = timestampFrom + (long) (rando.nextDouble() * timeRange);
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        raceDate = formatter.format(new Date(randomTimestamp));
        System.out.println("The new race on " + raceDate +  "has been added!");

        ArrayList<Integer> list = new ArrayList<>(size);
        for(int i = 1; i <= size; i++) {list.add(i);}
        for (Formula1Driver driver : driverList) {
            driver.raceDateList.add(raceDate);
            Random rand = new Random();
            int index = rand.nextInt(list.size());
            int element = list.get(index);
            list.remove(index);
            int currentPoints;
            switch (element) {
                case 1 -> {
                    driver.setPointsPerRace(25);
                    driver.setPositionNo1();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("1");

                }
                case 2 -> {
                    driver.setPointsPerRace(18);
                    driver.setPositionNo2();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("2");

                }
                case 3 -> {
                    driver.setPointsPerRace(15);
                    driver.setPositionNo3();
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("3");

                }
                case 4 -> {
                    driver.setPointsPerRace(12);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("4");

                }

                case 5 -> {
                    driver.setPointsPerRace(10);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("5");

                }
                case 6 -> {
                    driver.setPointsPerRace(8);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("6");

                }
                case 7 -> {
                    driver.setPointsPerRace(6);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("7");

                }
                case 8 -> {
                    driver.setPointsPerRace(4);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("8");

                }
                case 9 -> {
                    driver.setPointsPerRace(2);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("9");

                }
                case 10 -> {
                    driver.setPointsPerRace(1);
                    currentPoints = driver.getTotalPoints() + driver.getPointsPerRace();
                    driver.setTotalPoints(currentPoints);
                    driver.setRaces();
                    driver.positionList.add("10");

                }
            }

        }
    }
    public void saveInfo() {
        ObjectOutputStream oOut = null;
        try {
            FileOutputStream fOut = new FileOutputStream("driverObjects.txt");
            oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(driverList);
            oOut.close();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oOut != null) {
                    oOut.flush();
                    oOut.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("The data has been saved!");
    }
    public void recoverInfo() {
        try {
            FileInputStream fIn = new FileInputStream("driverObjects.txt");
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            driverList = (ArrayList<Formula1Driver>) oIn.readObject();
            System.out.println(driverList.toString());
            oIn.close();
            fIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    public void SortPoints(){
        driverList.sort(Comparator.comparingInt(Formula1Driver::getTotalPoints));
        System.out.println("Formula 1 Championship 2022 Stats table");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s", "DRIVER", "|", "LOCATION", "|", "TEAM", "|", "POINTS", "|", "1ST POSITIONS", "|",
                "RACES");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for (Formula1Driver driver : driverList) {
            System.out.format("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s",
                    driver.getDriverName(), "|", driver.getDriverLocation(), "|", driver.getDriverTeam(), "|",
                    driver.getTotalPoints(), "|", driver.getPositionNo1(), "|", driver.getRaces() + "\n");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
    public void sortFp(){
        driverList.sort((Formula1Driver s1, Formula1Driver s2)->s2.getPositionNo1()-s1.getPositionNo1());
        System.out.println("Formula 1 Championship 2022 Stats table");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s", "DRIVER", "|", "LOCATION", "|", "TEAM", "|", "POINTS", "|", "1ST POSITIONS", "|",
                "RACES");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for (Formula1Driver driver : driverList) {
            System.out.format("%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s",
                    driver.getDriverName(), "|", driver.getDriverLocation(), "|", driver.getDriverTeam(), "|",
                    driver.getTotalPoints(), "|", driver.getPositionNo1(), "|", driver.getRaces() + "\n");
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
    public void search() throws ParseException {
        System.out.println("Enter the name of the driver you wish to search for: ");
        String statDriver = input.next();
        for (Formula1Driver driver : driverList) {
            if (statDriver.equals(driver.getDriverName())) {
                System.out.println(" ");
                int n = driver.raceDateList.size();
                Date[] date= new Date[n];
                String[] str = new String[n];
                String[]date1= new String[n];
                for(int j=0;j<n;j++){String element = driver.raceDateList.get(j);str[j]=element;}

                SimpleDateFormat sobj = new  SimpleDateFormat("dd/MM/yyyy");// format specified in double quotes

                for(int i=0;i<n;i++){date[i]=sobj.parse(str[i]);}

                Arrays.sort(date);
                int counter =0;
                for(Date i : date){date1[counter]=sobj.format(i);counter++;}

                List<String> sortedracedate = Arrays.asList(date1);
                List<String> sortedracepos = new ArrayList<>(n);

                for(String d: sortedracedate){
                    int index;
                    index = driver.raceDateList.indexOf(d);
                    System.out.println(index);
                    String posdate = driver.positionList.get(index);
                    sortedracepos.add(posdate);}

                System.out.println("-----------------------------------");
                System.out.printf("%10s %10s %10s\n", "   Race Date","|", "  Position Gained");
                System.out.println("-----------------------------------");

                for(int i=0; i<n;i++){
                    System.out.printf("%10s %10s %10s\n", sortedracedate.get(i),"|", sortedracepos.get(i));
                }
                System.out.println("-----------------------------------");

            }
            }
        }
    public void searchGui(String statDriver) throws ParseException {

        for (Formula1Driver driver : driverList) {
            if (statDriver.equals(driver.getDriverName())) {

                int n = driver.raceDateList.size();
                Date[] date= new Date[n];
                String[] str = new String[n];
                String[]date1= new String[n];
                for(int j=0;j<n;j++){String element = driver.raceDateList.get(j);str[j]=element;}

                SimpleDateFormat sobj = new  SimpleDateFormat("dd/MM/yyyy");// format specified in double quotes

                for(int i=0;i<n;i++){date[i]=sobj.parse(str[i]);}

                Arrays.sort(date);
                int counter =0;
                for(Date i : date){date1[counter]=sobj.format(i);counter++;}

                List<String> sortedracedate = Arrays.asList(date1);
                List<String> sortedracepos = new ArrayList<>(n);

                for(String d: sortedracedate){
                    int index;
                    index = driver.raceDateList.indexOf(d);
                    System.out.println(index);
                    String posdate = driver.positionList.get(index);
                    sortedracepos.add(posdate);}
                System.out.println(sortedracepos);
                driver.setSortPositionList( sortedracepos);
                driver.setSortRaceDateList( sortedracedate);


            }

        }
    }
    public void probability(){
        for (Formula1Driver driver : driverList) {


            int occur1 = Collections.frequency(driver.positionList, "1");
            int occur2 = Collections.frequency(driver.positionList, "2");
            int occur3 = Collections.frequency(driver.positionList, "3");
            int occur4 = Collections.frequency(driver.positionList, "4");
            int occur5 = Collections.frequency(driver.positionList, "5");
            int occur6 = Collections.frequency(driver.positionList, "6");
            int occur7 = Collections.frequency(driver.positionList, "7");
            int occur8 = Collections.frequency(driver.positionList, "8");
            int occur9 = Collections.frequency(driver.positionList, "9");
            int occur3_4 = occur3+occur4;
            int occur5_9 = occur5+occur6+occur7+occur8+occur9;
            int probab1 = 40;
            int probab2 = 30;
            int probab3_4 = 10;
            int probab5_10 = 2;
            int probNum = probab1*occur1 + probab2*occur2 + probab3_4*occur3_4 + probab5_10*occur5_9;
            int probDom = (occur1+occur2+occur3_4+occur5_9);
            if (probDom>0){
            System.out.println(probNum);
            System.out.println(probDom);
            System.out.println(driver.getPositionList());

            driver.setProb( probNum/probDom);
            System.out.println(driver.getProb());
                System.out.println("--------------");
            }




        }


    }
    public void completeData(){
        for (Formula1Driver driver : driverList) {
            System.out.println(driver.toString());
        }
    }
}
