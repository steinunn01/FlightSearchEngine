package main.java.com.model;

public class Airplane{
    private String airplaneID;
    private String airline;
    private Seat[] seats;

    public Airplane(String airID, String airL, Seat[] seats){
	airplaneID = airID;
	airline = airL;
	this.seats = seats;
    }

    //Use : getAirline();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneId.
    public String getAirline(){
	return airline;
    }

    //Use : getSeats();
    //pre : nothing.
    //post: returns a matrix of Seat.    
    public Seat[] getSeats(){
	return seats;
    }

    //Use : getID();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneID.
    public String getId(){
	    return airplaneID;
    }
}
