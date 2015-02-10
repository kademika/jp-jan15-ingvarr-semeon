package com.kademika.day10.shop_gui_discount;

public class SUV extends Car { //Sports Utility Vehicle
	private static final String SUV = "SUV";
	
	public SUV(String brend, String model, CarColor color, double capacity, GearboxType gearbox,
			double fuelConsumption, int trunkVolume, int price) {
		super(brend, model, color, capacity, gearbox, fuelConsumption, trunkVolume, price);
		super.setBodyType(SUV);
		super.setVIN((int)(Math.random()*998) + 4001); //4001..4999
	}
	
	@Override
	public String toString() {
		return this.getBodyType() + " " + super.toString();

	}
}
