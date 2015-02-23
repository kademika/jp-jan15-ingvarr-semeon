package com.kademika.day10.generics.wildcards.smartsort;

import com.kademika.day10.domain.Car;
import com.kademika.day10.domain.KIASportage;
import com.kademika.day10.domain.NissanQashqai;
import com.kademika.day10.domain.Porshe911;

import java.util.ArrayList;
import java.util.List;

public class CarServiceDemo {

    public static void main(String[] args) {
        Porshe911 porshe911 = new Porshe911(3.6, 100000);
        NissanQashqai nissanQashqai = new NissanQashqai(2.0, 28280.5);
        KIASportage kiaSportage = new KIASportage(2.0, 29355.0);

        List<Car> cars = new ArrayList<>();
        cars.add(porshe911);
        cars.add(nissanQashqai);
        cars.add(kiaSportage);

        for (Car car : cars) {
            System.out.println(car.toString());
        }

        CarService service = new CarService();
        service.sortCars(cars);

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
