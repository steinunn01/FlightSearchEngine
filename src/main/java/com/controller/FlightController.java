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

    public void addFlight(Flight f) throws Exception{
	    db.add(f);
	    setFlights();
    }

    public void delFlight(Flight f) throws Exception{
        db.del(f);
	    setFlights();
    }

    public Flight findFligt(String id, String depart, String departT){
        return db.find(id, depart, departT);
    }

    public void update(String id, String depart, String departT, Flight nf) throws Exception{
        Flight f = findFligt(id, depart, departT);
        if(f != null){
            if(nf != null){
                db.update(f, nf);
            }
            else{
                db.del(f);
            }
            setFlights();
        }
        else{
            if(nf != null){
                db.add(f);
                setFlights();
            }
        }
    }
}
