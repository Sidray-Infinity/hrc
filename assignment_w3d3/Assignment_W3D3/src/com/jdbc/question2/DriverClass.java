package com.jdbc.question2;
import java.sql.*;
import java.util.*;

public class DriverClass {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/example_schema";
	    String username = "root";
	    String password = "root";
	    
	    try {
			// Making connection to DB
		    System.out.println("Connecting...");
		    Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
		    System.out.println("Connected");
		    
		    List<TestPOJO> records = new ArrayList<TestPOJO>();
		    
		    String query = "SELECT * FROM test_table";
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    
		    while(rs.next()) {
		    	TestPOJO r = new TestPOJO();
		    	String first_name = rs.getString("first_name");
		    	if(first_name.length() == 0)
		    			r.setFirst_name("");
		    	else
		    		r.setFirst_name(first_name);
		    	
		    	String last_name = rs.getString("last_name");
		    	if(last_name.length() == 0)
		    			r.setLast_name("");
		    	else
		    		r.setLast_name(last_name);
		    	
		    	String serial_number = rs.getString("serial_number");
		    	if(serial_number.length() == 0)
		    			r.setSerial_number(0);
		    	else
		    		r.setSerial_number(Integer.parseInt(serial_number));
		    	
		    	String also_known_as = rs.getString("also_known_as");
		    	if(also_known_as.length() == 0)
		    			r.setAlso_known_as("");
		    	else
		    		r.setAlso_known_as(also_known_as);
		    	
		    	String moto = rs.getString("moto");
		    	if(last_name.length() == 0)
		    			r.setMoto("");
		    	else
		    		r.setMoto(moto);
		    	
		    	records.add(r);
		    }
		    
		    for(int i=0; i<records.size(); i++) {
		    	System.out.print(records.get(i).getFirst_name() + ' ');
		    	System.out.print(records.get(i).getLast_name() + ' ');
		    	System.out.print(records.get(i).getSerial_number() + ' ');
		    	System.out.print(records.get(i).getAlso_known_as() + ' ');
		    	System.out.print(records.get(i).getMoto() + ' ');
		    	System.out.println();
		    }
		    
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }

	}

}
