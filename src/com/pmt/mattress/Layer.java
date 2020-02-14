package com.pmt.mattress;

public class Layer {
	private String name;
	private double unitPrice;
	private double thickness;
	private double totalPrice;
	private int surface;
	
	public Layer(double thickness, String name, MattressSize size) {
		this.thickness = thickness;
		surface = size.getSurface();
		DBAccess dba = new DBAccess();
		unitPrice = dba.getFoamPrice(name);
		totalPrice = thickness*surface*unitPrice;
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
	
	public double getTotalPrice() {
		return totalPrice;
	}
}
