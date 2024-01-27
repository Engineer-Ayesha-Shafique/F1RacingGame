package com.Computer_Engineer_2020_CE_39;

import java.io.Serializable;

public abstract class Driver implements Serializable {
   String driverName;
    String driverLocation;
    String driverTeam;
    public Driver(String driverName, String driverLocation, String driverTeam){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.driverTeam = driverTeam;
        }
    public Driver() {}
    public String getDriverName(){return driverName;}
    public String getDriverLocation(){return driverLocation;}
    public String getDriverTeam() { return driverTeam; }
    public void setDriverTeam(String driverTeam) {this.driverTeam = driverTeam;}
    public void setDriverName(String driverName) {this.driverName = driverName;}
    public void setDriverLocation(String driverLocation) {this.driverLocation = driverLocation;}
}
