package com.Computer_Engineer_2020_CE_39;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula1Driver extends Driver implements Serializable{
    //attributes
    private int positionNo1=0;
    private int positionNo2=0;
    private int positionNo3=0;
    private int totalPoints;
    private int races;
    private int pointsPerRace;
    private int prob;
    ArrayList<String > positionList = new ArrayList<String>();
    ArrayList<String > raceDateList = new ArrayList<String>();
    List<String > sortPositionList = new ArrayList<String>();
    List<String > sortRaceDateList = new ArrayList<String>();



    //Constructors
    public Formula1Driver(String name, String location, String team, int positionNo1,int positionNo2, int positionNo3, int points, int races){
        super(name, location, team);
        this.positionNo1 = positionNo1;
        this.positionNo2 = positionNo2;
        this.positionNo3 = positionNo3;
        this.totalPoints = points;
        this.races = races;

    }
    public Formula1Driver(int races, int points){
        this.races = races;
        this.totalPoints = points;
    }
    public Formula1Driver() {super();}

    public int getProb() {
        return prob;
    }

    public void setProb(int prob) {
        this.prob = prob;
    }

    public ArrayList<String> getRaceDateList() {
        return raceDateList;
    }

    public void setRaceDateList(ArrayList<String> raceDateList) {
        this.raceDateList = raceDateList;
    }

    public List<String> getSortPositionList() {
        return sortPositionList;
    }

    public void setSortPositionList(List<String> sortPositionList) {
        this.sortPositionList = sortPositionList;
    }

    public List<String> getSortRaceDateList() {
        return sortRaceDateList;
    }

    public void setSortRaceDateList(List<String> sortRaceDateList) {
        this.sortRaceDateList = sortRaceDateList;
    }

    //Getters
    public int getPositionNo1(){return positionNo1;}
    public int getPositionNo2(){return positionNo2;}
    public int getPositionNo3(){return positionNo3;}
    public int getTotalPoints(){return totalPoints;}
    public int getRaces(){return races;}
    public int getPointsPerRace() {return pointsPerRace;}
    public ArrayList<String> getPositionList() {return positionList;}


    //Setters
    public void setPositionNo1(){positionNo1++; }
    public void setPositionNo2(){positionNo2++; }
    public void setPositionNo3(){positionNo3++; }
    public void setTotalPoints(int points){totalPoints = points;}
    public void setRaces(){races++;}
    public void setPointsPerRace(int pointsPerRace) {this.pointsPerRace = pointsPerRace;}
    public void setPositionList(ArrayList<String> positionList) {this.positionList = positionList;}

/*
    //toString()
    @Override
    public String toString() {
        return  "Driver Name           :  "+ getDriverName()+
                "\nLocation of Driver    :  "+ getDriverLocation()+
                "\nTeam Name             :  " + getDriverTeam()+
                "\nNo. of 1st positions  :  " + getPositionNo1() +
                "\nNo. of 2nd positions  :  "+ getPositionNo2() +
                "\nNo. of 3rd positions  :  " + getPositionNo3() +
                "\nPoints                :  " + getTotalPoints() +
                "\n";
    }

    @Override
    public String toString() {
        return "Formula1Driver{" +
                "driverName='" + driverName + '\'' +

                ", driverTeam='" + driverTeam + '\'' +
                ", positionNo1=" + positionNo1 +
                ", positionNo2=" + positionNo2 +
                ", positionNo3=" + positionNo3 +
                ", totalPoints=" + totalPoints +
                ", races=" + races +
                ", myList=" + positionList +
                '}';
    }*/

    @Override
    public String toString() {
        return "Formula1Driver{" +
                "driverName='" + driverName + '\'' +
                ", driverTeam='" + driverTeam + '\'' +
                ", positionNo1=" + positionNo1 +
                ", positionNo2=" + positionNo2 +
                ", positionNo3=" + positionNo3 +
                ", totalPoints=" + totalPoints +
                ", races=" + races +
                ", prob=" + prob +
                ", positionList=" + positionList +
                ", raceDateList=" + raceDateList +
                '}';
    }
}