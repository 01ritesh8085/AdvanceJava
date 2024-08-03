package com.rays.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDelet {

	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from users where Id = 1");
		
		
		System.out.println("Data delete successfully... " + i);
	}
	
	
}
