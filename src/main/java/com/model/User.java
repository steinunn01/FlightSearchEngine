package main.java.com.model;

public class User {
    private String kennitala;
    private String passportId;
    private String fName;
    private String lName;
    private String email;
    private String password;

    public User (String kennitala, String passportId ,String fName, String lName, String email, String password) {
        this.kennitala = kennitala;
	this.passportId = passportId;
        this.fName = fName;
	this.lName = lName;
        this.email = email;
        this.password = password;
    }


    public String getKennitala() {
        return kennitala;
    }

    public void setKennitala(String kennitala) {
        this.kennitala = kennitala;
    }

    public String getPassportId(){
	return passportId;
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

}
