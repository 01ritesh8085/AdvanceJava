package com.rays.util;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Step 1 make class final Child can not created

public  final class JDBCDataSource {
	
	// Step 2 make self type of static variable static variable have one copy in
		// life time
	
	private static JDBCDataSource datasource;
	
	 private ComboPooledDataSource cpds = null;
	 
	 
	 
	 
	 
	 
	 private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

		// Step 3 make default constructor private object can not be created
		private JDBCDataSource() {
		}

		// Step 4 Make getInstance method to get instance of same class return same type
		// of instance
		public static JDBCDataSource getInstance() {

			if (datasource == null) {
				datasource = new JDBCDataSource();
				datasource.cpds = new ComboPooledDataSource();
				try {
					datasource.cpds.setDriverClass(rb.getString("driver"));
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));
				datasource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
				datasource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
				datasource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
			}
			return datasource;
		}

		public static Connection getConnection() throws Exception {
			return getInstance().cpds.getConnection();
		}

		public static void closeConnection(Connection connection) {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
			}
		}

		public static void trnRollback(Connection connection) throws Exception {
			if (connection != null) {

				try {
					connection.rollback();
				} catch (Exception ex) {
					throw new Exception(ex.toString());
				}
			}
		}

	}
	 
	 
	 
	 
	 
		
	
	
	


