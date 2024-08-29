package com.rays.test;

import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");
		System.out.println("Driver = " + rb.getString("driver"));
		System.out.println("url = " + rb.getString("url"));
		System.out.println("username = " + rb.getString("username"));
		System.out.println("pws = " + rb.getString("password"));

	}
	
	
}
