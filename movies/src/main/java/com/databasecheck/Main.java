package com.databasecheck;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "masterkey";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			if( myConn.isValid(0)) {
				System.out.println("Connection successful!!!");
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
