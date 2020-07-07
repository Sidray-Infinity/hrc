package com.jdbc.question1;
import java.sql.*;
import java.util.*;

public class SearchDB {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/example_schema";
	    String username = "root";
	    String password = "root";
	    
		String CREATE_TABLE_SQL = "CREATE TABLE test_table " + 
								  "(first_name VARCHAR(100), " +
								  "last_name VARCHAR(100), " +
								  "serial_number INTEGER NOT NULL, " +
								  "also_known_as VARCHAR(100), " +
								  "moto VARCHAR(100));";

	    
		try {
			// Making connection to DB
		    System.out.println("Connecting...");
		    Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
		    System.out.println("Connected");
		    
		    // Creating the table
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate(CREATE_TABLE_SQL);
		    System.out.println("Table Created");
		    
		    // Inserting values
		    String insert_q = "INSERT INTO test_table VALUES(" +
		    				  "'Alvaro','Morte',111,'Professor'," +
		    				  "'Sometimes a truce is the most important part of a war');";
		    stmt.executeUpdate(insert_q);
		    
		    insert_q = "INSERT INTO test_table VALUES(" +
  				  "'Ursula','Corbero',112,'Tokyo'," +
  				  "'When you hit rock bottom you still have a way to go until the abyss');";
		    stmt.executeUpdate(insert_q);
		    
		    insert_q = "INSERT INTO test_table VALUES(" +
  				  "'Alba','Flores',113,'Nairobi'," +
  				  "'Let the matriarchy begin');";
		    stmt.executeUpdate(insert_q);
		    
		    // Search for an entry
		    String column, value;
		    System.out.println("Enter the column, based on which search is to be made:");
		    column = scan.next();
		    
		    System.out.println("Enter the value:");
		    value = scan.next();
		    
		    String query = "SELECT * FROM test_table WHERE ? = ?;";
		    PreparedStatement q = conn.prepareStatement(query);
		    System.out.println(column);
		    if (column.equals("serial_number")) {
		    	query = "SELECT * FROM test_table WHERE serial_number = ?;";
		    	q = conn.prepareStatement(query);
			    q.setInt(1, Integer.parseInt(value));
		    }
		    else {
		    	switch(column) {
		    	case("first_name"):
		    		query = "SELECT * FROM test_table WHERE first_name = ?;";
			    	q = conn.prepareStatement(query);
				    q.setString(1, value);
				    break;
		    	case("last_name"):
		    		query = "SELECT * FROM test_table WHERE last_name = ?;";
			    	q = conn.prepareStatement(query);
				    q.setString(1, value);
				    break;
		    	case("also_known_as"):
		    		query = "SELECT * FROM test_table WHERE also_known_as = ?;";
			    	q = conn.prepareStatement(query);
				    q.setString(1, value);
				    break;
		    	case("moto"):
		    		query = "SELECT * FROM test_table WHERE moto = ?;";
			    	q = conn.prepareStatement(query);
				    q.setString(1, value);
				    break;
		    	}
		    }
		    
		    System.out.println(q);
		    
		    ResultSet rs = q.executeQuery();
		    if (rs.getFetchSize() != 1)
		    	System.out.println("Error!" + Integer.toString(rs.getFetchSize()));
		    
		    while(rs.next()) {
		    	String first_name = rs.getString("first_name");
		    	String last_name = rs.getString("last_name");
		    	int serial_number = rs.getInt("serial_number");
		    	String also_known_as = rs.getString("also_known_as");
		    	String moto = rs.getString("moto");
		    	
		    	System.out.println("-----------------------------------------------------");
		    	System.out.println("First Name:" + first_name);
		    	System.out.println("Last Name:" + last_name);
		    	System.out.println("Serial Number:" + Integer.toString(serial_number));
		    	System.out.println("Alias:" + also_known_as);
		    	System.out.println("Quote:" + moto);
		    	
		    }
		    	    		 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	    

	}

}
