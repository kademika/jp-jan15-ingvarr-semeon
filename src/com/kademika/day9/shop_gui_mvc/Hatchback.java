package com.kademika.day9.shop_gui_mvc;

public class Hatchback extends Car {
	private static final String HATCHBACK = "Hatchback";
	
	public Hatchback(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType(HATCHBACK);
		super.setVIN((int)(Math.random()*998) + 1001); //1001..1999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
