package com.kademika.day10.generics.supers.smartcopy;

import com.kademika.day10.domain.Car;

import java.util.List;

public class CarServ {

    public static void copy(List<? extends Car> src, List<? super Car> dest) {
        for (Car car : src) {
            dest.add(car);
        }
    }
}
