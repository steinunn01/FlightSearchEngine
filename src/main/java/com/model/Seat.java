package main.java.com.model;

public class Seat{
    private final int ROW;
    private final char COL;
    private int seatPrice;
    private boolean available;

    public Seat(int r, char c, int pice){
	    ROW = r;
	    COL = c;
	    seatPrice = pice;
	    available = true;
    }

    public int getROW(){
	    return ROW;
    }

    public char getCOL(){
        return COL;
    }

    public boolean isAvailble(){
	    return available;
    }

    public void changeAvali(){
	    if(available)
            available = false;
	    else
            available = true;
    }

    public int getSeatPrice(){
	    return seatPrice;
    }

    public void setPirce(int price){
	    seatPrice = price;
    }
}
