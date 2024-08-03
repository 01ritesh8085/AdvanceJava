package com.rays.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root" , "root");
		
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(
				"create table users(id int primary key, firstName varchar(50), lastName varchar(50), loginId varchar(50), password varchar(50), dob date, gender varchar(50))");

		System.out.println("tabe created = " + i);

		System.out.println("connection Successfully..");
		
		
		
		
	}
	
	
}
