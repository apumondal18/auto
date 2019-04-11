package com.loginform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginControler
 */
public class LoginControler extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		// Connect to mysql and verify username password
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 // loads driver
		//String dbuser = System.getenv("DB_USER");
		String dbuser1 = System.getProperty("DB_USER");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@orcl.cm5jhlauarpm.us-east-1.rds.amazonaws.com:1521:orcl", dbuser1, "password123"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select name,pass from userreg where name=? and pass=?");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
		
 
		while (rs.next()) {
			response.sendRedirect("success.html");
			return;
		}
		response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
