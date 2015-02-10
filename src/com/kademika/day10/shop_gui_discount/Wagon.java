package com.kademika.day10.shop_gui_discount;

public class Wagon extends Car {
	private static final String WAGON = "Wagon";
	
	public Wagon(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType(WAGON);
		super.setVIN((int)(Math.random()*998) + 6001); //6001..6999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
