package main.java.com.controller;

import main.java.com.model.*;
import main.java.com.tables.*;
import java.sql.*;

public class FlightController{
    private Flight[] filghts;
    private FlightTable db;

    public FlightController() throws Exception {
	    setFlights();
    }

    public void setFlights() throws Exception{
	    this.filghts = db.getFlights();
    }

    public Flight[] getFlight(){
	    return filghts;
    }

    public void addFlight(Flight f){
	    db.add(f);
	    setFlights();
    }

    public void delFlight(Flight f){
        db.del(f);
	    setFlights();
    }

    public Flight findFligt(Flight f){
        return db.find(f);
    }
}
