package com.pmt.mattress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAccess {
	private String dbPath = "jdbc:mysql://localhost:3306/mattress_components";
	private String username =  "root"; 
	private String password = "Zzh123456!";
	
	public double getFoamPrice(String name) {
		double returnValue = 0;
		try {
			Connection myConn = DriverManager.getConnection(dbPath, username, password);
			PreparedStatement myStmt = myConn.prepareStatement("select unit_price from foams where foam_name = ?");
			myStmt.setString(1, name);
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			returnValue = myRs.getDouble("unit_price");
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
		return returnValue;
	}
	
	public double getOutercoverPrice(String name) {
		double returnValue = 0;
		try {
			Connection myConn = DriverManager.getConnection(dbPath, username, password);
			PreparedStatement myStmt = myConn.prepareStatement("select unit_price from outercovers where name = ?");
			myStmt.setString(1, name);
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			returnValue = myRs.getDouble("unit_price");
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
		return returnValue;
	}
}
