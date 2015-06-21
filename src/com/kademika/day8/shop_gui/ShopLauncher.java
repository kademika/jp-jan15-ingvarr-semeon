package com.kademika.day8.shop_gui;

public class ShopLauncher {

	public static void main(String[] args) throws Exception {
		Shop shop = new Shop(10);
		carsDelivery(shop);
		
		ShopGUI gui = new ShopGUI(shop);
		
	}

	public static void carsDelivery(Shop shop) throws Exception {
		Hatchback hatch1 = new Hatchback("Ford", "Fiesta", CarColor.BLUE, 1.0,
				GearboxType.AUTOMATIC, 6.6, 276, 21093);
		Hatchback hatch2 = new Hatchback("Ford", "Fiesta", CarColor.YELLOW,
				1.0, GearboxType.AUTOMATIC, 6.6, 276, 21093);
		Hatchback hatch3 = new Hatchback("Ford", "Focus", CarColor.RED, 1.0,
				GearboxType.MANUAL, 6.3, 316, 25155);
		Hatchback hatch4 = new Hatchback("Ford", "Focus", CarColor.BROWN, 1.0,
				GearboxType.MANUAL, 6.3, 316, 25155);
		Pickup pickup1 = new Pickup("Ford", "Ranger", CarColor.BLUE, 2.2,
				GearboxType.CVT, 10.9, 1210, 36000);
		Sedan sedan1 = new Sedan("Ford", "Focus", CarColor.SILVER, 1.0,
				GearboxType.MANUAL, 6.4, 421, 25546);
		Sedan sedan2 = new Sedan("Ford", "Mondeo", CarColor.BLACK, 2.0,
				GearboxType.DSG, 10.7, 535, 37615);
		SUV suv1 = new SUV("Ford", "Kuga", CarColor.WHITE, 2.0,
				GearboxType.DSG, 7.4, 456, 36384);
		Van van1 = new Van("Ford", "S-Max", CarColor.OLIVE_GREEN, 2.0,
				GearboxType.DSG, 7.4, 1051, 39538);
		Van van2 = new Van("Ford", "C-Max", CarColor.SILVER, 1.0,
				GearboxType.MANUAL, 6.3, 432, 23905);
		Wagon wagon1 = new Wagon("Ford", "Focus", CarColor.RED, 1.6,
				GearboxType.DSG, 9.3, 476, 25714);
		try {
			shop.addToGarage(hatch1); //1
			shop.addToGarage(hatch2); //2
			shop.addToGarage(hatch3); //3
			shop.addToGarage(hatch4); //4
			shop.addToGarage(pickup1);//5
			shop.addToGarage(sedan1); //6
			shop.addToGarage(sedan2); //7
			shop.addToGarage(suv1);   //8
			shop.addToGarage(van1);   //9
			shop.addToGarage(wagon1); //10
			shop.addToGarage(van2);   //11
		} catch (ShopIsOverloadedException e) {
			System.out.println("..Places in the garage are over..");
		} finally {
			System.out.println("[Cars delivery was done]");
		}
	}
	
}
