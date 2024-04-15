package main.java.com.model;

public class Flight{
    private Airplane airplane;
    private final String derpartureLocation;
    private String departure;
    private final String arrivalLocation;
    private String arrival;
    private String status;

    public Flight(Airplane airp, String dL, String d, String aL, String a, String sta){
	airplane = airp;
	derpartureLocation = dL;
	departure = d;
	arrivalLocation = aL;
	arrival = a;
	status = sta;
    }
    
    //Use : getSeats();
    //pre : nothing.
    //post: returns a matrix of Seat.
    public Seat[][] getSeats(){
	return airplane.getSeats();
    }

    //Use : getAirplaneID();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneId.
    public Airplane getAirplane(){
	    return airplane;
    }

    //Use : getDepartureLoc();
    //pre : nothing.
    //post: returns the Sting value for
    //      derpartureLocation.
    public String getDepartureLoc(){
	return derpartureLocation;
    }

    public void setDepartureDate(String date){
	    departure = date;
    }
    
    //Use : getDepartureDate();
    //pre : nothing.
    //post: returns the Sting value for
    //      derparture.
    public String getDepartureDate(){
	    return departure;
    }

    //Use : getArrivalLoc();
    //pre : nothing.
    //post: returns the Sting value for
    //      arrivalLocation.
    public String getArrivalLoc(){
	    return arrivalLocation;
    }

    public void setArrivalTime(String time){
	    arrival = time;
    }
    
    //Use : getArrivalTime();
    //pre : nothing.
    //post: returns the Sting value for
    //      arrival.
    public String getArrivalTime(){
	    return arrival;
    }

    //Use : getStatus();
    //pre : nothing.
    //post: returns the Sting value for
    //      status.
    public String getStatus(){
	    return status;
    }
}
