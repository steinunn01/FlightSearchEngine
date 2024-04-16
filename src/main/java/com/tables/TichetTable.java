package main.java.com.tables;

import main.java.com.model.*;
import java.sql.*;

public class TichetTable{
    private Connection conn;

    private void getConn(String[] args) throws Exception{
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

    public Seat[] findFreeSeats(Flight f) throws SQLException, Exception{
		getConn(null);
		String stmt1 = "SELCET r, c, price, avilable FORM Seat WHERE airplenaID = ? AND avlible = TRUE";
		PreparedStatement p = conn.prepareStatement(stmt1);
		String id = f.getAirplane().getId();
		p.setString(1,id);
		ResultSet r = p.executeQuery();

		Seat[] seats = new Seat[2];
		int l = 2;

		int i = 0;
		while(r != null){
	    	if(i == l){
				l *= 2;
				seats = fixSize(seats, l);
	    	}

	    	int row = r.getInt(1);
	    	char col = r.getString(2).charAt(0);
	    	int price = r.getInt(3);
			boolean avilable = r.getBoolean(4);
	    	seats[i] = new Seat(row, col, price, avilable);

	    	i++;
	    	r.next();
		}
		conn.close();
		
		i++;
		if(i != l){
	    	seats = fixSize(seats, i);
		}
		return seats;
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
}
