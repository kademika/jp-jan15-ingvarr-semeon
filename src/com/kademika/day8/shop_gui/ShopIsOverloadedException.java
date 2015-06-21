package com.kademika.day8.shop_gui;

public class ShopIsOverloadedException extends RuntimeException {
	
	public ShopIsOverloadedException() {
		System.out.println("(!) Shop is overloaded. Should extend your shop (!)");
	}
}
