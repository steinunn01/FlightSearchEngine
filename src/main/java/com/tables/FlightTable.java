package main.java.com.tables;

import main.java.com.model.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  

public class FlightTable{
    private Connection conn;

    private void getConn(String args[]) throws Exception{
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
	getConn(null);
	Statement s = conn.createStatement();
	
	String stmt1 = "SELECT * FROM Flight;";
	ResultSet r = s.executeQuery(stmt1);
	stmt1 =  "SELCET c, r, price, avilable FORM Seat WHERE airplenaID = ? and depart = ? and departTime = ?";

	Flight[] ret = new Flight[2];
	int l = 2;

	int i = 0;
	while(r != null){
	    if(i == l){
		l *= 2;
		ret = fixSize(ret, l);
	    }
	    
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		DateFormat dateFormat2 = new SimpleDateFormat("hh:mm");

	    String id = r.getString(1);
	    String de = r.getString(2);
	    String ded = dateFormat.format(r.getDate(3));
	    String det = dateFormat2.format(r.getTime(4));
	    String arri = r.getString(5);
	    String arrit =  dateFormat2.format(r.getTime(6));
	    String sat = r.getString(7);

	    ResultSet r2 = s.executeQuery(stmt1);
	    String airline = r2.getString(1);

	    PreparedStatement p = conn.prepareStatement(stmt1);
	    p.setString(1,id);
	    p.setString(2, ded);
	    p.setString(3, det);

	    r2 = p.executeQuery();

	    Seat[] seats = new Seat[2];
	    int k = 2;

	    int j = 0;
	    while(r2 != null){
	    	if(k == j){
		    l *= 2;
		    seats = fixSize(seats, l);
	    	}

	    	int row = r2.getInt(1);
	    	char col = r2.getString(2).charAt(0);
	    	int price = r2.getInt(3);
			boolean avilable = r2.getBoolean(4);
	    	seats[j] = new Seat(row, col, price, avilable);

	    	j++;
	    	r2.next();
	    }
		
	    j++;
	    if(i != k){
	    	seats = fixSize(seats, i);
	    }

	    Airplane airp = new Airplane(id, airline, seats);

	    ret[i] = new Flight(airp, de, ded, det, arri, arrit, sat);

	    p.clearParameters();
	    i++;
	    r.next();
	}
	i++;
	if(i != l){
	    ret = fixSize(ret, i);
	}
	conn.close();
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

    public void add(Flight f)throws Exception{
	getConn(null);
	String stmt1 = "SELECT airplaneID, depart, departTime From Flight where airplaneID = ? and depart = ? and departTime = ?";
	PreparedStatement p = conn.prepareStatement(stmt1);

	String id = f.getAirplane().getId();
	String date = f.getDepartureDate();
	String time = f.getDepartureDate();

	p.setString(1, id);
	p.setString(2, date);
	p.setString(3, time);

	ResultSet r = p.executeQuery();
	p.clearParameters();

	if(r == null){
	    stmt1 = "SELECT * FROM Airplane WHERE id = ?";
	    p = conn.prepareStatement(stmt1);
	    p.setString(1, id);

	    r = p.executeQuery();
	    p.clearParameters();

	    if(r != null){
		Airplane air = f.getAirplane();
		Seat[] seats = air.getSeats();
		int l = seats.length;

		stmt1 = "INSERT INTO Seat value (?, ?, ?, True, ?, ?, ?)";
		p = conn.prepareStatement(stmt1);

		for(int i = 0; i < l; i++){
		    p.setInt(1, seats[i].getROW());
		    p.setString(2, String.valueOf(seats[i].getCOL()));
		    p.setInt(3, seats[i].getSeatPrice());
		    p.setString(4, id);
		    p.setString(5, date);
		    p.setString(6, time);

		    p.executeUpdate();
		    p.clearParameters();
		}

		stmt1 = "INSERT INTO Flight value (?, ?, ?, ?, ?, ? ,?)";
		p = conn.prepareStatement(stmt1);
		p.setString(1,id);
		p.setString(2,f.getDepartureLoc());
		p.setString(3, date);
		p.setString(4, time);
		p.setString(5, f.getArrivalLoc());
		p.setString(6, f.getArrivalTime());
		p.setString(7, f.getStatus());

		p.executeUpdate();
		p.clearParameters();
	    }
	}
	conn.close();
    }
	
	public void del(Flight f)throws Exception{
		getConn(null);
		String stmt1 = "SELECT airplaneID, depart, departTime From Flight where airplaneID = ? and depart = ? and departTime = ?";
		PreparedStatement p = conn.prepareStatement(stmt1);
	
		String id = f.getAirplane().getId();
		String date = f.getDepartureDate();
		String time = f.getDepartureDate();
	
		p.setString(1, id);
		p.setString(2, date);
		p.setString(3, time);
	
		ResultSet r = p.executeQuery();
		p.clearParameters();
	
		if(r != null){
			Airplane air = f.getAirplane();
			Seat[] seats = air.getSeats();
			int l = seats.length;
	
			stmt1 = "DELETE FROM Seat WHERE r = ? and c = ? and airplaneID = ? and depart = ? and departTime = ?";
			p = conn.prepareStatement(stmt1);
	
			for(int i = 0; i < l; i++){
				p.setInt(1, seats[i].getROW());
				p.setString(2, String.valueOf(seats[i].getCOL()));
				p.setString(3, id);
				p.setString(4, date);
				p.setString(5, time);
	
				p.executeUpdate();
				p.clearParameters();
			}
	
			stmt1 = "DELETE FROM Flight WHERE airplaneID = ? and depart = ? and departTime = ?";
			p = conn.prepareStatement(stmt1);
			p.setString(1,id);
			p.setString(3, date);
			p.setString(4, time);
	
			p.executeUpdate();
			p.clearParameters();
			}
		conn.close();
		}

	public void update(Flight f, Flight nf)throws Exception{
		getConn(null);
		String stmt1 = "SELECT airplaneID, depart, departTime From Flight where airplaneID = ? and depart = ? and departTime = ?";
		PreparedStatement p = conn.prepareStatement(stmt1);

		String id = f.getAirplane().getId();
		String date = f.getDepartureDate();
		String time = f.getDepartureDate();
	
		p.setString(1, id);
		p.setString(2, date);
		p.setString(3, time);
	
		ResultSet r = p.executeQuery();
		p.clearParameters();
		conn.close();
	
		if(r != null){
			del(f);
			add(nf);
		}
	}

    public Flight find(String id, String date, String time) throws Exception{
		getConn(null);
		Flight ret = null;
		String stmt1 = "SELECT airline FROM Airplane WHERE airplaneID = ?";
		PreparedStatement p = conn.prepareStatement(stmt1);

		p.setString(1, id);

		ResultSet r = p.executeQuery();
		p.clearParameters();

		if(r != null){
			String airline = r.getString(1);
				
			Seat[] seats = new Seat[2];
			int l = 2;

			stmt1 = "SELECT r, c, price, avilable FROM Seat WHERE airplaneID = ?, depart = ?, departTime = ?";
			p = conn.prepareStatement(stmt1);
			
			p.setString(1, id);
			p.setString(2,date);
			p.setString(3,time);
			
			r = p.executeQuery();
			p.clearParameters();

			int i = 0;
			while (r != null) {
				if(l >= i){
					l *= 2;
					fixSize(seats, l);
				}

				int row = r.getInt(1);
				char col = r.getString(2).charAt(0);
				int price = r.getInt(3);
				boolean avilable = r.getBoolean(4);

				seats[i] = new Seat(row, col, price, avilable);
			}

			Airplane airplane = new Airplane(id, airline, seats);

			stmt1 = "SELECT departLoc, arrival, arrivalLoc, status FROM Flight WHERE airplaneID = ? and depart = ? and departTime = ?";
			p = conn.prepareStatement(stmt1);

			p.setString(1, id);
			p.setString(2,date);
			p.setString(3,time);

			r = p.executeQuery();
			p.clearParameters();

			ret = new Flight(airplane, r.getString(1), date, time, r.getString(3), r.getString(2), r.getString(4));
		}
		
		conn.close();
		return ret;
	}
	
}
