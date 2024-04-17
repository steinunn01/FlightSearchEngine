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

	public void cancelBooking(Ticket t) throws Exception{
		String ariplaneId = t.getFlight().getAirplane().getId();
		String date = t.getFlight().getDepartureDate();
		String time = t.getFlight().getDepartureTime();

		int row = t.getSeat().getROW();
		char col = t.getSeat().getCOL();

		String stmt1 = "UPDATE Seat set avilable = TRUE WHERE r = ? AND c = ? AND airplaneID = ? AND depart = ? AND departTime = ?";
		getConn(null);
		PreparedStatement p = conn.prepareStatement(stmt1);

		p.setInt(1, row);
		p.setString(2,String.valueOf(col));
		p.setString(3,date);
		p.setString(4, time);

		p.executeUpdate();
		p.clearParameters();

		stmt1 = "DELETE FROM Ticked WHERE userID = ? AND passportID = ? AND airplaneID = ? AND depart = ? AND departTime = ? AND r = ? AND c = ?";
		p = conn.prepareStatement(stmt1);

		p.setString(1, t.getKennitala());
		p.setString(2, t.getPassportNum());
		p.setString(3, ariplaneId);
		p.setString(4, date);
		p.setString(5, time);
		p.setInt(6, row);
		p.setString(7, String.valueOf(col));

		p.executeUpdate();
		p.clearParameters();
		
		conn.close();
	}
	
	public Ticket bookTicked(User u, Flight f, Seat s, int bag, String id, String passId) throws Exception{
		String userId = u.getKennitala();

		String airplanId = f.getAirplane().getId();
		String date = f.getDepartureDate();
		String time = f.getDepartureTime();

		int row = s.getROW();
		char col = s.getCOL();
		
		String stmt1 = "UPDATE Seat set avilable = FALSE WHERE r = ? AND c = ? AND airplaneID = ? AND depart = ? AND departTime = ?";
		getConn(null);
		PreparedStatement p = conn.prepareStatement(stmt1);

		p.setInt(1, row);
		p.setString(2, String.valueOf(col));
		p.setString(3, airplanId);
		p.setString(4, date);
		p.setString(5, time);
		
		p.executeUpdate();
		p.clearParameters();
		s.changeAvali();

		stmt1 = "INSERT INTO Ticked VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		p = conn.prepareStatement(stmt1);

		p.setString(1, userId);
		p.setString(2,passId);
		p.setString(3, airplanId);
		p.setString(4,date);
		p.setString(5,time);
		p.setString(6,id);
		p.setInt(7,bag);
		p.setInt(8,row);
		p.setString(9,String.valueOf(col));
		
		p.executeUpdate();
		p.clearParameters();
		conn.close();

		return new Ticket(f, s, userId, id, passId, bag);
	}

	public Ticket[] findAllBooking(User u) throws Exception{
		String id = u.getKennitala();

		return findAllBooking(id);
	}

	
	public Ticket[] findAllBooking(String id) throws Exception{
		getConn(null);
		String stmt1 = "SELECT airplaneID, r, c, passportID, depart, departTime, id, bagas FROM Ticked WHERE userID = ?";
        PreparedStatement p = conn.prepareStatement(stmt1);

        p.setString(1,id);

        ResultSet r = p.executeQuery();
        p.clearParameters();
        conn.close();

        Ticket[] ret = new Ticket[2];
        int l = 2;

        stmt1 = "SELECT price, avilable FROM Seat WHERE r = ? AND c = ? AND airplaneID = ? AND depart = ? AND departTime = ?";

        int i = 0;
        while (r != null) {
            if(i <= l){
                l*=2;
                fixSize(ret, l);
            }
            String airplaneid = r.getString(1);
            int row = r.getInt(2);
            char col = r.getString(3).charAt(0);
            String passportId = r.getString(4);
            String date = r.getString(5);
            String time = r.getString(6);
            String ticketnum = r.getString(7);
            int bag = r.getInt(8);

            FlightTable temp = new FlightTable();
            Flight flight = temp.find(airplaneid, date, time);

            getConn(null);
            p = conn.prepareStatement(stmt1);
                
            p.setInt(1, row);
            p.setString(2, String.valueOf(col));
            p.setString(3, airplaneid);
            p.setString(4, date);
            p.setString(5, time);

            ResultSet r1 = p.executeQuery();
            p.clearParameters();
            conn.close();

            int price = r1.getInt(1);
            boolean avilable = r1.getBoolean(2);

            Seat seat = new Seat(row, col, price, avilable);
            ret[i] = new Ticket(flight, seat, id, ticketnum, passportId, bag);

            i++;
            r.next();
        }

        if(i != l){
            fixSize(ret, i);
        }

		return ret;
	}

	public Ticket[] findAllBooking(User u, Flight f) throws Exception{
		String userId = u.getKennitala();

		String airplanId = f.getAirplane().getId();
		String date = f.getDepartureDate();
		String time = f.getDepartureTime();

		getConn(null);
		String stmt1 = "SELECT r, c, passportID, id, bag FROM Ticked WHERE userID = ? AND airplaneID = ? AND depart = ? AND departTime = ?";
		PreparedStatement p = conn.prepareStatement(stmt1);

		p.setString(1, userId);
		p.setString(2, airplanId);
		p.setString(3, date);
		p.setString(4, time);
		
		ResultSet r = p.executeQuery();
		p.clearParameters();

		Ticket[] ret = new Ticket[2];
        int l = 2;

		stmt1 = "SELECT price, avilable FROM Seat WHERE r = ? AND c = ? AND airplaneID = ? AND depart = ? AND departTime = ?";

        int i = 0;
        while (r != null) {
            if(i <= l){
                l*=2;
                fixSize(ret, l);
            }
            int row = r.getInt(1);
            char col = r.getString(2).charAt(0);
			String passId = r.getString(3);
            String ticketnum = r.getString(4);
            int bag = r.getInt(5);

            p = conn.prepareStatement(stmt1);
                
            p.setInt(1, row);
            p.setString(2, String.valueOf(col));
            p.setString(3, airplanId);
            p.setString(4, date);
            p.setString(5, time);

            ResultSet r1 = p.executeQuery();
            p.clearParameters();

            int price = r1.getInt(1);
            boolean avilable = r1.getBoolean(2);

            Seat seat = new Seat(row, col, price, avilable);
            ret[i] = new Ticket(f, seat, userId, ticketnum, passId, bag);

            i++;
            r.next();
        }
		conn.close();
        if(i != l){
            fixSize(ret, i);
        }

		return ret;
	}

	public Ticket finedBook(User u, Flight f, Seat s) throws Exception{
		String userId = u.getKennitala();
		
		String stmt1 = "SELECT passportID, id, bag FROM Ticked WHERE userID = ? AND airplaneID = ? AND depart = ? AND departTime = ? AND r = ? AND c = ?";
		getConn(null);
		PreparedStatement p = conn.prepareStatement(stmt1);

		p.setString(1, userId);
		p.setString(2, f.getAirplane().getId());
		p.setString(3, f.getDepartureDate());
		p.setString(4, f.getDepartureTime());
		p.setInt(5, s.getROW());
		p.setString(6, String.valueOf(s.getCOL()));
		ResultSet r = p.executeQuery();
		
		p.clearParameters();
		conn.close();

		return new Ticket(f, s, userId, r.getString(2), r.getString(1), r.getInt(3));
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

	private Ticket[] fixSize(Ticket[] s, int l){
        Ticket[] ret = new Ticket[l];
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
