package com.kademika.day10.shop_gui_discount;

public class Van extends Car {
	private static final String VAN = "Van";
	
	public Van(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType(VAN);
		super.setVIN((int)(Math.random()*998) + 5001); //5001..5999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
