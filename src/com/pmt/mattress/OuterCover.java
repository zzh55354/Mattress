package com.pmt.mattress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OuterCover {
	private String name;
	private double coversurface;
	private double unitPrice;
	private double totalPrice;
	OuterCover(String name, double height, MattressSize size) {
		this.name = name;
		getUnitPrice(name);
		setSurface(size.getCircumference(), size.getSurface(), height);
		totalPrice = unitPrice*coversurface;
	}
	
	private void getUnitPrice(String name) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mattress_components", "root", "Zzh123456!");
			PreparedStatement myStmt = myConn.prepareStatement("select unit_price from outercovers where name = ?");
			myStmt.setString(1, name);
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			unitPrice = myRs.getDouble("unit_price");
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	public void setSurface(int circumference, int surface, double height) {
		coversurface =  circumference * height + 2 * surface;
	}
	
	public double getPrice() {
		return totalPrice;
	}
	
	public String getName() {
		return name;
	}
}
