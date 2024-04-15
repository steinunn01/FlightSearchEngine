package main.java.com.model;

import java.util.*;

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

    public Map<Integer, Character> getSeatID(){
	    Map<Integer, Character> seatID = new HashMap<Integer, Character>();
	    seatID.put(ROW, COL);
	    return seatID;
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
