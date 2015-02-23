package com.kademika.day10.shop_gui_discount;

public class RequestedCarIsAbsentException extends RuntimeException {
	
	public RequestedCarIsAbsentException() {
		System.out.println("(!) Requested car is absent (!)");
	}
}
