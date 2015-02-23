package com.kademika.day10.domain;

public abstract class SportsCar extends Car {
    private boolean isSportModeEnabled;

    public abstract void enableSportMode();

    public boolean getIsSportModeEnabled() {
        return isSportModeEnabled;
    }

    protected void setSportModeEnabled(boolean isSportModeEnabled) {
        this.isSportModeEnabled = isSportModeEnabled;
    }
}
