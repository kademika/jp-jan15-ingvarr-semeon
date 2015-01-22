package com.kademika.day10.generics.wildcards;

import com.kademika.day10.domain.Car;

import java.util.List;

public class CarService {

    public Car findCar(List<? extends Car> cars, Car car) {
        return null; //car's finding method realization should be here
    }
}
