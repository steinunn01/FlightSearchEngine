package main.java.com.controller;

import main.java.com.model.*;
import test.java.com.mock.FilgthTableMock;

public class FlightController{
    private Flight[] filghts;
    private FilgthTableMock db;

    public FlightController(){
	    db = new FilgthTableMock();
	    filghts = setFlights;
    }

    public void setFlights(){
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
