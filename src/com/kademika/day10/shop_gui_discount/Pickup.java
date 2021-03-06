package com.kademika.day10.shop_gui_discount;

public class Pickup extends Car {
	public static final String PICKUP = "Pickup";
	
	public Pickup(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, double price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType(PICKUP);
		super.setVIN((int)(Math.random()*998) + 2001); //2001..2999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
