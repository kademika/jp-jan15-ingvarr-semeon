package com.kademika.day10.domain;

public class KIASportage extends SUV {

    public KIASportage() {
    }

    public KIASportage(double capacity, double price) {
        super.setBrand("KIA");
        super.setModel("Sportage");
        super.setCapacity(capacity);
        super.setPrice(price);
    }

    @Override
    public void enable4WDMode() {
        super.setIs4WDModeEnabled(true);
    }
}
