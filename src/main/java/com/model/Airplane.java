package main.java.com.model;

public class Airplane{
    private String airplaneID;
    private String airline;
    private Seat[][] seats;

    public Airplane(String airID, String airL, int row, int col, int seatPrice){
	airplaneID = airID;
	airline = airL;
	setSeats(row, col, seatPrice);
    }

    public void setSeats(int r, int c, int seatPrice){
	    seats = new Seat[r][c];
	
	    for(int i = 0; i < r; i++){
	        for(int j = 0; j < c; j++){
		        seats[i][j] = new Seat(i+1, (char)(65+j), seatPrice);
	        }
	    }
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
    public Seat[][] getSeats(){
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
