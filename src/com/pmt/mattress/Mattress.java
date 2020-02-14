package com.pmt.mattress;

import java.util.ArrayList;

public class Mattress {
	
	private String name;
	private MattressSize size = MattressSize.QUEEN; 
	private double height = 0.0;
	private ArrayList <Layer> Layers = new ArrayList<Layer>();
	private OuterCover outerCover;
	
	
	public Mattress(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSize(MattressSize size ) {
		this.size = size;
	}
	
	public MattressSize getSize() {
		return size;
	}
		
	public void addLayer(Layer l ) {
		this.Layers.add(l);
		height += l.getThickness();
	}
	
	public void removeLayer(Layer l) {
		
	}
	
	public double getHeight() {
		return height;
	}
	
	public void printLayers() {
		for(int i = 0; i < Layers.size(); i++) {
			Layers.get(i).printLayer();
		}
	}
	
	public void addOuterCover(OuterCover OC) {
		outerCover = OC;
	}

	public double calPrice() {
		double Price = 0;
		for(int i = 0; i < Layers.size(); i++) {
			Price += Layers.get(i).getTotalPrice();
		}
		Price += outerCover.getPrice();
		return Price;
	}

}