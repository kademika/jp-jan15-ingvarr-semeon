package com.kademika.day10.generics.wildcards.smartsort;

import com.kademika.day10.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class CarBox<T extends Car> {

    private List<T> cars;

    public CarBox() {
        cars = new ArrayList<>();
    }

    public void addCar(T car) {
        cars.add(car);
    }

    public List<T> getCars() {
        return new ArrayList<>(cars);
    }
}
