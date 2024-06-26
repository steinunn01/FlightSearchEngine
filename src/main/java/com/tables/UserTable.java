package main.java.com.tables;

import main.java.com.model.*;
import java.sql.*; 

public class UserTable{
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

    public User logIn(String id, String pw) throws Exception{
        User ret = null;

        if(isPassword(id,pw)){
            getConn(null);
            
            String stmt1 = "SELECT FName, LName, email FROM Users WHERE id = ?";
            PreparedStatement p = conn.prepareStatement(stmt1);

            p.setString(1, id);
            ResultSet r = p.executeQuery();
            p.clearParameters();
            conn.close();
            
            String fName = r.getString(1);
            String lName = r.getString(2);
            String email = r.getString(3);

            TichetTable temp = new TichetTable();
            Ticket[] booking = temp.findAllBooking(id);
           
            ret = new User(id, fName, lName, email, pw, booking);
        }

        return ret;
    }

    public void signIn(User use, String pass) throws Exception{
        if(use.password(pass)){
            getConn(null);
            String stmt1 = "INSERT INTO Users VALUES (?, ?, ?, ?, ?)";

            PreparedStatement p = conn.prepareStatement(stmt1);
            p.setString(1,use.getKennitala());
            p.setString(2, use.getFName());
            p.setString(3, use.getLName());
            p.setString(4,use.getEmail());
            p.setString(5, pass);

            p.executeUpdate();
            p.clearParameters();
            conn.close();
        }
    }

    public void del(User use, String pass) throws Exception{
        String id = use.getKennitala();
        
        if(isPassword(id, pass)){
            String stmt1 = "DELETE FROM Users Where id = ?";

            getConn(null);
            PreparedStatement p = conn.prepareStatement(stmt1);

            p.setString(1, id);
            
            p.executeUpdate();
            p.clearParameters();
            conn.close();
        }
    }

    private boolean isPassword(String id, String password) throws Exception{
        getConn(null);
        String stmt1 = "SELECT Pasword FROM Users WHERE id = ?";

        PreparedStatement p = conn.prepareStatement(stmt1);
        p.setString(1, id);

        ResultSet r = p.executeQuery();
        p.clearParameters();

        String rpw = r.getString(1);
        conn.close();

        return password == rpw;
    }
}
