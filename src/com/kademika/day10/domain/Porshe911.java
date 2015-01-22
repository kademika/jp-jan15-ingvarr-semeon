package com.kademika.day10.domain;

public class Porshe911 extends SportsCar {

    public Porshe911() {
    }

    public Porshe911(String brand, String model, double price) {
        super.setBrand(brand);
        super.setModel(model);
        super.setPrice(price);
    }

    @Override
    public void enableSportMode() {
        super.setSportModeEnabled(true);
    }
}
