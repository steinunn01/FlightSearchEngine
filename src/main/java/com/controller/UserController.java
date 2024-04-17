package main.java.com.controller;

import main.java.com.model.*;
import main.java.com.tables.*;

public class UserController{
    private User user;
    private boolean logIn;
    private UserTable db;

    public UserController(String id, String password) throws Exception{
	logIn = false;
	logInUser(id, password);
    }

    public void logInUser(String id, String password) throws Exception{
	if(!logIn){
	    user = db.logIn(id, password);

	    if(user != null){
		logIn = true;
	    }
	}
    }

    public void logOutUser(){
	if(logIn){
	    logIn = false;
	    user = null;
	}
    }

    public void signUpUser(User u, String password) throws Exception{
	if(!logIn){
	    db.signIn(u, password);
	    logInUser(u.getKennitala(), password);
	}
    }

    public void delUser(String password) throws Exception{
	if(logIn){
	    db.del(user, password);
		user = null;
		logIn = false;
	}
    }

    public User getUser(){
	return user;
    }

    public boolean getLogIn(){
	return logIn;
    }
}
	
