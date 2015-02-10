package com.kademika.day10.shop_gui_discount;

public class ShopIsOverloadedException extends RuntimeException {
	
	public ShopIsOverloadedException() {
		System.out.println("(!) Shop is overloaded. Should extend your shop (!)");
	}
}
