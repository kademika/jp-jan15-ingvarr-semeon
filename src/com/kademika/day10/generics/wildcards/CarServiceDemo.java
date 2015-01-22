package com.kademika.day10.generics.wildcards;

import com.kademika.day10.domain.Car;
import com.kademika.day10.domain.NissanQashqai;
import com.kademika.day10.domain.Porshe911;

import java.util.ArrayList;
import java.util.List;

public class CarServiceDemo {

    public static void main(String[] args) {
        Porshe911 porshe911 = new Porshe911();
        NissanQashqai nissanQashqai = new NissanQashqai();

        List<Car> cars = new ArrayList<>();
        cars.add(porshe911);
        cars.add(nissanQashqai);

        CarService service = new CarService();
        service.findCar(cars, nissanQashqai);
        service.findCar(cars, porshe911);
    }
}
