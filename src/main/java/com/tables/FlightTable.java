package main.java.com.tables;

import main.java.com.model.*;
import java.util.*;
import java.sql.*;

public class FlightTable{
    private Connection conn;

    private void getConn() throws Exception{
	try{
	    Class.forName("org.postgresql.Driver");
	    java.util.Properties props = new java.util.Properties();
	    props.setProperty("user",args[0]);
	    props.setProperty("password",args[1]);
	    conn = DriverManager.getConnection("jdbc:postgresql:com/dateBasa/db",props);
	}
	catch(Exception e){
	    try{
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:com/dateBasa/db.db");
	    }
	    catch(Exception e2){
		conn = DriverManager.getConnection("jdbc:odbc:com/dateBasa/db");
	    }
	}
    }

    public Flight[] getFlights() throws SQLException, Exception{
	getConn();
	Statement s = conn.createStatement();
	
	String stmt1 = "SELECT * FROM Flight;";
	ResultSet r = s.executeQuery(stmt1);
	stmt1 =  "SELCET c, r, price FORM Seat WHERE airplenaID = ? and depart = ? and departTime = ?";

	Flight[] ret = new Flight[2];
	int l = 2;

	int i = 0;
	while(r != null){
	    if(i == l){
		l *= 2;
		ret = fixSize(ret, l);
	    }
	    
	    String id = r.getString(1);
	    String de = r.getString(2);
	    Date ded = r.getDate(3);
	    Time det = r.getTime(4);
	    String arri = r.getString(5);
	    Time arrit = r.getTime(6);
	    String sat = r.getString(7);

	    String Stmt2 = "SELECT airline FROM Airplane WHERE id = "+ id;
	    ResultSet r2 = s.executeQuery(stmt1);
	    String airline = r2.getString(1);

	    PreparedStatement p = conn.prepareStatement(stmt1);
	    p.setString(1,id);
	    p.setDate(2, ded);
	    p.setTime(3, det);

	    r2 = p.executeQuery();

	    Seat[] seats = new Seat[2];
	    int k = 2;

	    int j = 0;
	    while(r2 != null){
	    	if(k == j){
		    l *= 2;
		    seats = fixSize(seats, l);
	    	}

	    	int row = r.getInt(1);
	    	char col = r.getString(2).charAt(0);
	    	int price = r.getInt(3);
	    	seats[j] = new Seat(row, col, price);

	    	j++;
	    	r2.next();
	    }
		
	    j++;
	    if(i != k){
	    	seats = fixSize(seats, i);
	    }

	    Airplane airp = new Airplane(id, airline, seats);

	    ret[i] = new Flight(airp, de, ded, det, arri, arrit, sat);

	    i++;
	    r.next();
	}
	i++;
	if(i != l){
	    ret = fixSize(ret, i);
	}
	return ret;
    }

    private Seat[] fixSize(Seat[] s, int l){
	Seat[] ret = new Seat[l];
	int k = s.length;
	if(k < l){
	    for(int i = 0; i < k; i++){
		ret[i] = s[i];
	    }
	}
	else{
	    for(int i = 0; i < l; i++){
		ret[i] = s[i];
	    }
	}
	return ret;
    }

    private Flight[] fixSize(Flight[] f, int l){
	Flight[] ret = new Flight[l];
	int k = f.length;
	if(k < l){
	    for(int i = 0; i < k; i++){
		ret[i] = f[i];
	    }
	}
	else{
	    for(int i = 0; i < l; i++){
		ret[i] = f[i];
	    }
	}
	return ret;
    }
}
