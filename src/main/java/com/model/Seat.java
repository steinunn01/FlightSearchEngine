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
	availble = true;
    }

    public Map<int, char> getSeatID(){
	Map seatID = new Map<int, char>;
	seatID.add(ROW, COL);
	return seatID;
    }

    public boolean isAvailble(){
	return available;
    }

    public void changeAvali(){
	if(availble)
	    availble = false;
	else
	    availble = true;
    }

    public int getSeatPrice(){
	return seatPrice;
    }

    public void chengeSeatP(int price){
	seatPrice = price;
    }
}
