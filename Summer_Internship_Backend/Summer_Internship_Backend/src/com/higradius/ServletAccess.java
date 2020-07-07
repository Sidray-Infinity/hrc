package com.higradius;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import java.sql.*;

@WebServlet("/access_db")
public class ServletAccess extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String url = "jdbc:mysql://localhost:3306/project";
	private String userName = "root";
	private String password = "root";
	
	public ServletAccess() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		// Set response content type
//	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
//	      String title = "Database Result";
	      
//	      String docType =
//	    	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      
	      List<Record> result_pojo_objs = new ArrayList<Record>();
	      Gson gson = new Gson();

//	      out.println(docType +
//	    	         "<html>\n" +
//	    	         "<head><title>" + title + "</title></head>\n" +
//	    	         "<body>\n" +
//	    	         "<h1 align = \"center\">" + title + "</h1>\n");
	      try {
	    	  	
	    	  	// Establishing connection
	    	  	System.out.println("Connecting to DB..");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection dbCon = DriverManager.getConnection(url, userName, password);
				System.out.println("Connected to DB");
				
				// Executing query and storing data and metadata
				Statement stmt = dbCon.createStatement();
				String sql;
				sql = "SELECT * FROM customer_invoice";
				
				ResultSet rs = stmt.executeQuery(sql);
				
				// Creating a metadataobject
				ResultSetMetaData rsmd = rs.getMetaData();
				int num_columns = rsmd.getColumnCount();
				
				while(rs.next()) {

					Record r = new Record();
					r.set_values(rs);
					result_pojo_objs.add(r);
				}
				
		        String json_response = gson.toJson(result_pojo_objs);
	
		        
		        response.setContentType("application/json;charset=UTF-8");
		        request.setAttribute("jsonString", json_response);
		        out.print(json_response);
//		        request.getRequestDispatcher("/index.jsp").forward(request, response);
//		        request.getRequestDispatcher("http://localhost:3000/1705919/customer-dashboard").forward(request, response);
		   
	      }
	      catch(SQLException e) {
	    	  e.printStackTrace();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}

		        
				// DIRECTLY MAKING THE TABLE WITHOUT CONVERTING TO JSON (TEST)
		        
//				out.println("<table border=1><tr>");
//				for(int i=1; i<=num_columns;i++) {
//					out.println("<th>" + rsmd.getColumnName(i));
//				}
//				out.println("</tr>");
//				
//				while(rs.next()) {
//					out.println("<tr>");
//					for(int i=1; i<num_columns; i++)
//						out.println("<td>" + rs.getObject(i) + "</td>");
//					out.println("</tr>");
//				}
//				
//				out.println("</body></html>");
	    	  


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
