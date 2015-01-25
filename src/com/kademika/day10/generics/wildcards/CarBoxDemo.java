package com.kademika.day10.generics.wildcards;

import com.kademika.day10.domain.KIASportage;
import com.kademika.day10.domain.NissanQashqai;
import com.kademika.day10.domain.Car;
import com.kademika.day10.domain.Porshe911;

public class CarBoxDemo {

    public static void main(String[] args) {
        CarBox<Car> cars = new CarBox<>();
        
        cars.addCar(new Porshe911(3.6, 100000));
        cars.addCar(new NissanQashqai(2.0, 28280.5));
        cars.addCar(new KIASportage(2.0, 29355.0));

        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }

        CarService service = new CarService();
        service.sortCars(cars.getCars()); // ???

        for (Car car : cars.getCars()) {
            System.out.println(car.toString()); //Should be KIA, Nissan, Porshe
        }

    }
}
