package com.kademika.day10.generics.wildcards.smartsort;

import com.kademika.day10.domain.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarService {

    public Car findCar(List<? extends Car> cars, Car car) {
        return null; //car's finding method realization should be here
    }

    public void sortCars(List<? extends Car> cars) {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
        });
    }
}
