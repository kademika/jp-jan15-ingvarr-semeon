package com.kademika.day9.shop_gui_mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Shop {
	private Car[] garage;
	private ArrayList<Transaction> transactions;
	private int[] weeklyTransactionsCounter;

	public Shop(int shopCapacity) {
		garage = new Car[shopCapacity];
		transactions = new ArrayList<>();
		weeklyTransactionsCounter = new int[7];
	}

	public void addToGarage(Car car) {
		int i = 0;
		for (; i < garage.length; i++) {
			if (garage[i] == null) {
				garage[i] = car;
				return;
			}
		}
		throw new ShopIsOverloadedException();
	}

	public Car getCar(String brend, String model, CarColor color,
			double capacity, GearboxType gearbox) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i] != null && garage[i].getBrend() == brend && garage[i].getModel() == model
					&& garage[i].getColor() == color
					&& garage[i].getCapacity() == capacity
					&& garage[i].getGearbox() == gearbox) {
				return garage[i];
			}
		}
		throw new RequestedCarIsAbsentException();
	}
	
	public Car[] getGarage() {
		return garage;
	}

	public void sell(String date, Car car, Customer customer) {
		Car carForSale = this.getCar(car.getBrend(), car.getModel(),
				car.getColor(), car.getCapacity(), car.getGearbox());
		
		customer.setOwnCar(carForSale);
		this.handOut(carForSale);
		this.registerTransaction(date, customer, carForSale);
		System.out.println(car.getBodyType() + " " 
						+ car.getBrend() + " " 
						+ car.getModel() + " " 
						+ "was sold for " + car.getPrice() + " USD");
	}
	
	private void handOut(Car car) {
		for (int i = 0; i < garage.length; i++) {
			if (garage[i] != null && garage[i].getBrend() == car.getBrend() && garage[i].getModel() == car.getModel()
					&& garage[i].getColor() == car.getColor()
					&& garage[i].getCapacity() == car.getCapacity()
					&& garage[i].getGearbox() == car.getGearbox()) {
				garage[i] = null;
				return;
			}
		}
		throw new RequestedCarIsAbsentException();
	}
	
	private void registerTransaction(String dd_mm_yyyy, Customer customer, Car car) {
		transactions.add(new Transaction(dd_mm_yyyy, customer, car));
	}

	public void getPriceList() {
		if (garage != null) {
			Car[] list = new Car[garage.length];

			for (int i = 0, j = 0; i < garage.length; i++) {
				boolean foundMarker = false;
				for (Car car : list) {
					if (garage[i] != null && car != null
							&& car.getPrice() == garage[i].getPrice()) {
						foundMarker = true;
						break;
					}
				}
				if (foundMarker == false) {
					list[j++] = garage[i];
				}
			}

			System.out.println("Price list (USD):");
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null && list[i].getPrice() != 0) {
					System.out.println(list[i].getVIN() + " "
							+ list[i].getBodyType() + " " + list[i].getBrend()
							+ " " + list[i].getModel() + " : "
							+ list[i].getPrice());
				}
			}
			System.out.println();
		}
	}
	
	public void inStock() {
		int counterHatchback = 0;
		int counterPickup = 0;
		int counterSedan = 0;
		int counterSUV = 0;
		int counterVan = 0;
		int counterWagon = 0;

		for (int i = 0; i < garage.length; i++) {
			if (garage[i] != null) {
				if (garage[i].getBodyType() == "Hatchback") {
					counterHatchback += 1;
				} else if (garage[i].getBodyType() == "Pickup") {
					counterPickup += 1;
				} else if (garage[i].getBodyType() == "Sedan") {
					counterSedan += 1;
				} else if (garage[i].getBodyType() == "SUV") {
					counterSUV += 1;
				} else if (garage[i].getBodyType() == "Van") {
					counterVan += 1;
				} else if (garage[i].getBodyType() == "Wagon") {
					counterWagon += 1;
				}
			}
		}
		System.out.println();
		System.out.println("In stock (qty):" + "\n Hetchback: "
				+ counterHatchback + "\n Pickup: " + counterPickup
				+ "\n Sedan: " + counterSedan + "\n SUV: " + counterSUV
				+ "\n Van: " + counterVan + "\n Wagon: " + counterWagon);
		System.out.println();
	}
	
	public void outTransactionsList() {
		System.out.println("Transactions History:");
		for (Transaction t : transactions) {
			System.out.println(t);
		}
	}
	
	public ArrayList<Transaction> getAllTransactions() {
		return transactions;
	}
	
	public void weeklySalesReport() {
		this.transactionsCount();
		System.out.println();
		System.out.print("Last week sales qty: [");
		int length = weeklyTransactionsCounter.length - 1;
		for (int i = 0; i < length; i++) {
			System.out.print(weeklyTransactionsCounter[i] + ", ");
		}
		System.out.println(weeklyTransactionsCounter[length] + "]");
	}
	
	private void transactionsCount() {
		for (int i = 0; i < transactions.size(); i++) {
			if ( transactions.get(i) != null && (Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1))) ) {
				weeklyTransactionsCounter[6] += 1;
			} else if ( transactions.get(i) != null && (Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1)) - 1) ) {
				weeklyTransactionsCounter[5] += 1;
			} else if ( transactions.get(i) != null && (Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1)) - 2) ) {
				weeklyTransactionsCounter[4] += 1;
			} else if ( transactions.get(i) != null && (Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1)) - 3) ) {
				weeklyTransactionsCounter[3] += 1;
			} else if ( transactions.get(i) != null &&(Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1)) - 4) ) {
				weeklyTransactionsCounter[2] += 1;
			} else if ( transactions.get(i) != null && (Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1)) - 5) ) {
				weeklyTransactionsCounter[1] += 1;
			} else if ( transactions.get(i) != null && (Integer.parseInt(transactions.get(i).getDate().substring(0, 1))) 
					== (Integer.parseInt(getCurrentDate().substring(0, 1)) - 6) ) {
				weeklyTransactionsCounter[0] += 1;
			}
		}
	}
	
	private String getCurrentDate() {
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(date);
        //System.out.println("Today : " + today);
        return today;
	}
	
}
