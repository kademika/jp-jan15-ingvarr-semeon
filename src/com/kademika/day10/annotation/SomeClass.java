package com.kademika.day10.annotation;

public class SomeClass {

    private String name;
    private int prodYear;

    public void doSomething() {
        System.out.println("Something was done.");
    }

    @InitService
    public void init() {
        setName("Some Class");
        setProdYear(2014);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }
}
