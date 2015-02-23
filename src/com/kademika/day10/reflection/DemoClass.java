package com.kademika.day10.reflection;

public class DemoClass {
    private String name;
    private double version;
    private int prodactionYear;
    
    public String nickName;
    public int score;
    
    public DemoClass() {
    }
    
    public DemoClass(String name, double version, int prodactionYear) {
    	this.setName(name);
    	this.setVersion(version);
    	this.setProdactionYear(prodactionYear);
    }
    
    public DemoClass(String nickName, int score) {
    	this.nickName = nickName;
    	this.score = score;
    }
    
    public DemoClass(String name, double version, int prodactionYear, String nickName, int score) {
    	this.setName(name);
    	this.setVersion(version);
    	this.setProdactionYear(prodactionYear);
    	this.nickName = nickName;
    	this.score = score;
    }
    
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
