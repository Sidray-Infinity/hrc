package com.higradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.io.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import java.sql.*;
import com.google.gson.Gson;

@WebServlet("/update_db")
public class UpdateDB extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private String url = "jdbc:mysql://localhost:3306/project";
	private String userName = "root";
	private String password = "root";
	
	public UpdateDB() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		  Gson gson = new Gson();
		
	      try {
	    	  	
	    	  	// Establishing connection
	    	  
	    	  	String doctype;
	    	  	float open_amount;
	    	  	int document_number;
	    	 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection dbCon = DriverManager.getConnection(url, userName, password);
				
				StringBuffer jb = new StringBuffer();
			    String line = null;
		
		        BufferedReader reader = request.getReader();
		        while ((line = reader.readLine()) != null) {
		            jb.append(line);
		        } 
		        
		        System.out.println(jb);
		        String[] arr = new String(jb).split("\"");
		        
		        doctype = arr[3];
		        open_amount = Float.parseFloat(arr[6].substring(1, arr[6].length()-1));
		        document_number = Integer.parseInt(arr[8].substring(1, arr[8].length()-1));
		        
		        PreparedStatement pstmt = dbCon.prepareStatement("UPDATE customer_invoice SET actual_open_amount = ?, doctype = ? WHERE document_number = ?;");
		        pstmt.setFloat(1, open_amount);
		        pstmt.setString(2, doctype);
		        pstmt.setInt(3, document_number);
		        
		        pstmt.execute();
				
				
//				System.out.println(request.getAttribute("doctype"));
//				BufferedReader reader = request.getReader();
//				StringBuffer jb = new StringBuffer();
//				String line = null;
//				while ((line = reader.readLine()) != null)	
//					jb.append(line);
//				 
//				System.out.println(jb);
				
//				System.out.println(request);
//				System.out.println(request.getAttribute("doctype"));
//				System.out.println(request.getAttribute("open_amount"));
//				Enumeration<String> s = request.getAttributeNames();
//				while(s.hasMoreElements())
//					System.out.println(s.nextElement());
				// Executing query and storing data and metadata
				Statement stmt = dbCon.createStatement();
				String sql;
				
	      }
	      catch(SQLException e) {
	    	  e.printStackTrace();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
