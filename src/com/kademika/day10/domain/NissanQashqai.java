package com.kademika.day10.domain;

public class NissanQashqai extends SUV {

    public NissanQashqai() {
    }

    public NissanQashqai(double capacity, double price) {
        super.setBrand("Nissan");
        super.setModel("Qashqai");
        super.setCapacity(capacity);
        super.setPrice(price);
    }


    @Override
    public void enable4WDMode() {
        super.setIs4WDModeEnabled(true);
    }
}
