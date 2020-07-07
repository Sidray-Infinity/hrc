package com.question2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q2Servlet")
public class Q2Servlet extends HttpServlet {
	
	public Q2Servlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String username = "root";
		String password = "root";

		
		try {
			
			String ip_username = request.getParameter("user_name");
			String ip_password = request.getParameter("pswd");
			
			if(ip_username.equals(username) && ip_password.equals(password)) {
				response.getWriter().write("Correct Credentials!");
			}
			else
				response.getWriter().write("Wrong Credentials!");
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