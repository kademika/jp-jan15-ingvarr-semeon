package com.kademika.day10.domain;

public abstract class SUV extends Car {
    private boolean is4WDModeEnabled;

    public abstract void enable4WDMode();

    public boolean getIs4WDModeEnabled() {
        return is4WDModeEnabled;
    }

    protected void setIs4WDModeEnabled(boolean is4WDModeEnabled) {
        this.is4WDModeEnabled = is4WDModeEnabled;
    }
}
