package com.kademika.day10.domain;

public class NissanQashqai extends SUV {

    public NissanQashqai() {
    }

    public NissanQashqai(String brand, String model, double price) {
        super.setBrand(brand);
        super.setModel(model);
        super.setPrice(price);
    }


    @Override
    public void enable4WDMode() {
        super.setIs4WDModeEnabled(true);
    }
}
