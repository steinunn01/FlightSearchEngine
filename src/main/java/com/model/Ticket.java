package main.java.com.model;

public class Ticket {
    private Flight flight;
    private Seat seat;
    private String kennitala;
    private String ticketNum;
    private String passportNum;
    private int baggage;
    
    public Ticket(Flight f, Seat seat, String userId, String ticketNum, String passportNum, int bag) {
        flight = f;
        this.seat = seat;
        kennitala = userId;
        this.ticketNum = ticketNum;
        this.passportNum = passportNum;
        baggage = bag;
    }

    public void setBag(int bag){
	    baggage = bag; 
    }

    public int getBaggage(){
        return baggage;
    }

    public Seat getSeat(){
	return seat;
    }

    //use : getTicketNumber();
    //pre : nothing
    //post: retures the String value of
    //	    ticketNum.
    public String getTickerNumber(){
	    return ticketNum;
    }

    //use : getFlight();
    //pre : nothing
    //post: retures the Flight object
    //	    fligth.
    public Flight getFlight(){
	    return flight;
    }

    //use : getUser();
    //pre : nothing
    //post: retures the User object
    //	    user.
    public String getKennitala(){
	    return kennitala;
    }

    public String getPassportNum(){
        return passportNum;
    }
}
