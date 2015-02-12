package com.kademika.day10.reflection;

public class DemoClass {
    private String name;
    private double version;
    private int prodactionYear;
    
    public String nickName;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public int getProdactionYear() {
		return prodactionYear;
	}

	public void setProdactionYear(int prodactionYear) {
		this.prodactionYear = prodactionYear;
	}
    
}
