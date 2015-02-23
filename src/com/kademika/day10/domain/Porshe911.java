package com.kademika.day10.domain;

public class Porshe911 extends SportsCar {

    public Porshe911() {
    }

    public Porshe911(double capacity, double price) {
        super.setBrand("Porshe");
        super.setModel("911");
        super.setCapacity(capacity);
        super.setPrice(price);
    }

    @Override
    public void enableSportMode() {
        super.setSportModeEnabled(true);
    }
}
