package com.kademika.day10.annotation;

@Service
public class ServiceClass {

    private String name;
    private int prodYear;

    public void servicing() {
        System.out.println("Servicing was completed.");
    }

    @InitService
    public void init() {
        setName("Service Class");
        setProdYear(2015);
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
