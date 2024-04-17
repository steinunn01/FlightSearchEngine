package main.java.com.model;

public class User {
    private final String kennitala;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private Ticket[] booking;

    public User (String kennitala, String fName, String lName, String email, String password, Ticket[] booking) {
        this.kennitala = kennitala;
        this.fName = fName;
	this.lName = lName;
        this.email = email;
        this.password = password;
        this.booking = booking;
    }


    public String getKennitala() {
        return kennitala;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String nafn) {
        this.fName = nafn;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String nafn) {
        this.lName = nafn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean password(String p) {
        return p == password;
    }

    public void setPassword(String oldPassword, String newPassword) {
	if(password == oldPassword){
	    this.password = newPassword;
	}
    }

    public Ticket[] getBooking(){
        return booking;
    }

    public void setBooking(Ticket[] booking){
        this.booking = booking;
    }

}
