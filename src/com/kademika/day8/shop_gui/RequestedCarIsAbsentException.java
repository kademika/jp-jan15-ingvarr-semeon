package com.kademika.day8.shop_gui;

public class RequestedCarIsAbsentException extends RuntimeException {
	
	public RequestedCarIsAbsentException() {
		System.out.println("(!) Requested car is absent (!)");
	}
}
