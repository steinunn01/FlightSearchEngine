package main.java.com.model;

public class Airplane{
    private String airplaneID;
    private String airline;
    private Seat[][] seats;

    public Airplane(String airID, String airL, int row, char col, int seatPrice){
	airplaneID = airID;
	airline = airL;
	setSeats(row, col, seatPrice);
    }

    public setSeats(int r,char c, int seatPrice){
	int colLeght = int(col - 'A')+1;
	seats = new Seat[r+1][colLegth];
	
	for(int i = 0; i <= r; i++){
	    for(int j = 0; j < colLegth; i++){
		seats[i][j] = new Seat(i+1, char(65+1), seatPrice);
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

    public int getSeatPrice(int r, char c){
	return seats[r-1][int(c) - 65].getSeatPrice();
    }

    public boolean isSeatAvailble(int r, char c){
	return seats[r-1][int(c) - 65].isAvilble();
    }

    //Use : getID();
    //pre : nothing.
    //post: returns the Sting value for
    //      airplaneID.
    public String getId(){
	return ariplaneID;
    }
}
