package com.kademika.day9.shop_gui_mvc;

public class ShopIsOverloadedException extends RuntimeException {
	
	public ShopIsOverloadedException() {
		System.out.println("(!) Shop is overloaded. Should extend your shop (!)");
	}
}
