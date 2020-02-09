import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OuterCover {
	private String name;
	private double surface;
	private double unitPrice;
	private double totalPrice;
	OuterCover(String name, double height, String size) {
		this.name = name;
		getUnitPrice(name);
		this.surface = getSurface(size, height);
		totalPrice = unitPrice*surface;
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
	
	private double getSurface(String size, double height) {
		double length = 0;
		double width = 0;
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mattress_components", "root", "Zzh123456!");
			PreparedStatement myStmt = myConn.prepareStatement("select length, width from size_chat where size = ?");
			myStmt.setString(1, size);
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			length = myRs.getDouble("length");
			width = myRs.getDouble("width");
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
		return ((height*2*(length + width))+2*length*width);
	}

	public double getPrice() {
		return totalPrice;
	}
	
	public String name() {
		return name;
	}
}
