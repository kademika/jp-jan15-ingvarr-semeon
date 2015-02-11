package com.kademika.day10.shop_gui_discount;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShopTests {
	private Shop shop;
	private ShopLauncher shopLauncher;
	private Car carInexpensive1;
	private Car carExpensive1;
	private Car carInexpensive2;
	private Car carExpensive2;
	private Customer customer;
	
	@Before
	public void init() {
		shop = new Shop(10);
//		shopLauncher.carsDelivery(shop);
//		carInexpensive1 = new Car("Test"
//				, "Test011"
//				, CarColor.WHITE
//				, 1.0
//				, GearboxType.MANUAL
//				, 5.0
//				, 40
//				, 24999);
//		carExpensive1 = new Car("Test"
//				, "Test012"
//				, CarColor.WHITE
//				, 1.0
//				, GearboxType.MANUAL
//				, 5.0
//				, 40
//				, 25000);
//		carInexpensive2 = new Car("Test"
//				, "Test021"
//				, CarColor.WHITE
//				, 1.0
//				, GearboxType.MANUAL
//				, 5.0
//				, 40
//				, 29999);
//		carExpensive2 = new Car("Test"
//				, "Test022"
//				, CarColor.WHITE
//				, 1.0
//				, GearboxType.MANUAL
//				, 5.0
//				, 40
//				, 30000);
		customer = new Customer("Tester", "Tester1", "+380001234567");
	}
	
	@Test
	public void testSell() {
		shop.sell(new SimpleDateFormat("dd-MM-yyyy kk:mm:ss").format(new Date()), carInexpensive1, customer);
		for (Transaction t : shop.getAllTransactions()) {
			if (t.getCar().equals(carExpensive1)) {
				Assert.assertEquals(t.getDiscount(), carInexpensive1.getPrice());
			}
		}
		
	}
}
