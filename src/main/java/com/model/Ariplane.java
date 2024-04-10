package main.java.com.model;

public class Airplane{
    private String airplaneID;
    private String airline;
    private Seat[] seats;

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
	return ariplaneID;
    }
}
