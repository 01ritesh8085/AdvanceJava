package com.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJdbc {
	
	
	public static void main(String[] args) throws Exception {
		
		
		
		// Step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2 getConnection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root" , "root");
		
		//Step 3 Creat obj of Statement
		Statement stmt = conn.createStatement();
		
		
		
		
		System.out.println("connection is successfully");
		
	}

}
