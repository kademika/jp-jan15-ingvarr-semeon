package com.kademika.day10.shop_gui_discount;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShopTests {
    private Shop shop;
    private Car carInexpensive1;
    private Car carExpensive1;
    private Car carInexpensive2;
    private Car carExpensive2;
    private Customer customer;

	@Before
	public void init() {
		carInexpensive1 = new Hatchback("Test", "Test011", CarColor.WHITE, 1.0,
				GearboxType.MANUAL, 5.0, 40, 24999.0);
		carExpensive1 = new Sedan("Test", "Test012", CarColor.WHITE, 1.0,
				GearboxType.MANUAL, 5.0, 40, 25000.0);
		carInexpensive2 = new Wagon("Test", "Test021", CarColor.WHITE, 1.0,
				GearboxType.MANUAL, 5.0, 40, 29999.0);
		carExpensive2 = new SUV("Test", "Test022", CarColor.WHITE, 1.0,
				GearboxType.MANUAL, 5.0, 40, 30000.0);
		shop = new Shop(4);
		shop.addToGarage(carInexpensive1);
		shop.addToGarage(carExpensive1);
		shop.addToGarage(carInexpensive2);
		shop.addToGarage(carExpensive2);
		customer = new Customer("Tester", "Tester1", "+380001234567");
    }

    @Test
    //discount 0% if price < 25k
    public void testSellCarInexpensive1() {
        shop.sell(new SimpleDateFormat("dd-MM-yyyy kk:mm:ss").format(new Date())
                , carInexpensive1, customer);
        for (Transaction t : shop.getAllTransactions()) {
            if (t.getCar().equals(carInexpensive1)) {
                assertEquals(24999.0, t.getCar().getPrice(), 0.0);
            }
        }
    }

    @Test
    //discount 5% (1250.0) if price >= 25k
    public void testSellCarExpensive1() {
        shop.sell(new SimpleDateFormat("dd-MM-yyyy kk:mm:ss").format(new Date())
                , carExpensive1, customer);
        for (Transaction t : shop.getAllTransactions()) {
            if (t.getCar().equals(carExpensive1)) {
                assertEquals(23750.0, t.getCar().getPrice(), 0.0);
            }
        }
    }

    @Test
    //discount 5% (1499.95) if price >= 25k & < 30k
    public void testSellCarInexpensive2() {
        shop.sell(new SimpleDateFormat("dd-MM-yyyy kk:mm:ss").format(new Date())
                , carInexpensive2, customer);
        for (Transaction t : shop.getAllTransactions()) {
            if (t.getCar().equals(carInexpensive2)) {
                assertEquals(28499.05, t.getCar().getPrice(), 0.0);
            }
        }
    }

    @Test
    //discount 10% (3000.0) if price >= 30k
    public void testSellCarExpensive2() {
        shop.sell(new SimpleDateFormat("dd-MM-yyyy kk:mm:ss").format(new Date())
                , carExpensive2, customer);
        for (Transaction t : shop.getAllTransactions()) {
            if (t.getCar().equals(carExpensive2)) {
                assertEquals(27000.0, t.getCar().getPrice(), 0.0);
            }
        }
    }
}
