package com.pmt.mattress;
import java.sql.*;

public class Layer {
	private String name;
	private double unitPrice;
	private double thickness;
	private double totalPrice;
	private int surface;
	
	public Layer(double thickness, String name, MattressSize size) {
		this.name = name;
		this.thickness = thickness;
		surface = size.getSurface();
		getUnitPrice();
		totalPrice = thickness*surface*unitPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return unitPrice;
	}
	
	public double getThickness() {
		return thickness;
	}
	
	
	public void printLayer() {
		System.out.println(thickness + "\" " + name);
	}
	
	private void getUnitPrice() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mattress_components", "root", "Zzh123456!");
			PreparedStatement myStmt = myConn.prepareStatement("select unit_price from foams where foam_name = ?");
			myStmt.setString(1, getName());
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			unitPrice = myRs.getDouble("unit_price");
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
}
