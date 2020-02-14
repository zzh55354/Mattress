package com.pmt.mattress;

public class OuterCover {
	private String name;
	private double coversurface;
	private double unitPrice;
	private double totalPrice;
	OuterCover(String name, double height, MattressSize size) {
		this.name = name;
		DBAccess dba = new DBAccess();
		unitPrice = dba.getOutercoverPrice(name);
		setSurface(size.getCircumference(), size.getSurface(), height);
		totalPrice = unitPrice*coversurface;
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
