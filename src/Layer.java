import java.sql.*;

public class Layer {
	private String name;
	private String size;
	private double unitPrice;
	private double thickness;
	private double surface;
	private double totalPrice;
	
	public Layer(double thickness, String name, String size) {
		this.name = name;
		this.thickness = thickness;
		this.size = size;
		getUnitPrice();
		getSurface();
		totalPrice = thickness*surface*unitPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return unitPrice;
	}
	
	public String getSize() {
		return size;
	}
	
	public double getThickness() {
		return thickness;
	}
	
	private void getSurface() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mattress_components", "root", "Zzh123456!");
			PreparedStatement myStmt = myConn.prepareStatement("select area_in_inch from surface where size = ?");
			myStmt.setString(1, getSize());
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			surface = myRs.getDouble("area_in_inch");
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
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
