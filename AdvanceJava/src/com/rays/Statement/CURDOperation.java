package com.rays.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.source.tree.WhileLoopTree;

public class CURDOperation {

	public static void main(String[] args) throws Exception {
		
		//Add ();
		//Delete ();
		//Search ();
		//FindByLoginIdc();
		FindById();
		//Authenticate();
		//Update();
		
		}

	private static void Update() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();


				int i = stmt.executeUpdate("update users set firstName = 'Raman' where id = 1");

				System.out.println("Data Updated successfully... " + i);

		
	}

	private static void FindById() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from users where loginId=2");
		
		System.out.println("FindById is successfully Find");
	}

	private static void Authenticate() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from users where loginId='ram@gmail.com' and password = 'pass123'");
      
		 
			
		if (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getDate(6));
			System.out.println(rs.getString(7));
		
		}else {
			System.out.println("loginId or Password is invalid");
		}
			
		
		
		
		
		
	}

	private static void FindByLoginIdc() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from users where loginId='ram@gmail.com'");
		
		System.out.println("FindByLoginId is successfully Find");

		
	}

	private static void Search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from users");

		while (rs.next()) {

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getDate(6));
			System.out.println(rs.getString(7));
		}
		
		
	}

	private static void Delete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into users values(3, 'Raman', 'yaduvanshi', 'raman@gmail.com', 'pass123', '2002-01-21', 'Male')");

		System.out.println("Data inserted successfully... " + i);

		
	}

	private static void Add() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into users values(5, 'Milan', 'Malviya', 'milan@gmail.com', 'pass123', '2003-01-22', 'Male')");

		System.out.println("Data inserted successfully... " + i);

		
	}
	
	
	
	
	
}
