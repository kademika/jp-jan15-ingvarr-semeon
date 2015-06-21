package com.kademika.day9.shop_gui_mvc;

public class RequestedCarIsAbsentException extends RuntimeException {
	
	public RequestedCarIsAbsentException() {
		System.out.println("(!) Requested car is absent (!)");
	}
}
