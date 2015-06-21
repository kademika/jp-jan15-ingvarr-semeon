package com.kademika.day7.hashcode;

public class Address {
	private String city;
	private String street;
	private int house;
	
	public Address() {
	}
	
	public Address(String city, String street, int house) {
		if ( city == null || street == null || house <= 0) {
			throw new IllegalStateException("Address has not contains null / 0 values");
		}
		this.city = city;
		this.street = street;
		this.house = house;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			Address addr = (Address) obj;
			if (city.equals(addr.city) && street.equals(addr.street) && house == addr.house) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 25;
		result = 37 * result + city.hashCode();
		result = 37 * result + street.hashCode();
		result = 37 * result + house;
		return result;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getHouse() {
		return house;
	}
	
}
