package com.kademika.day10.shop_gui_discount;

public class Sedan extends Car {
	private static final String SEDAN = "Sedan";
	
	public Sedan(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, double price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType(SEDAN);
		super.setVIN((int)(Math.random()*998) + 3001); //3001..3999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
