package com.kademika.day9.shop_gui_mvc;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private String phoneNumber;
	private Car ownCar;
	
	public Customer(String name, String surname, String phoneNumber) {
		this.setName(name);
		this.setSurname(surname);
		this.setPhoneNumber(phoneNumber);
		this.setId((int)(Math.random()*98) + 101); //101..199
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Car getOwnCar() {
		return ownCar;
	}

	public void setOwnCar(Car ownCar) {
		this.ownCar = ownCar;
	}
	
}
