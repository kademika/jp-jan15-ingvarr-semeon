package com.kademika.day10.generics.wildcards;

import com.kademika.day10.domain.NissanQashqai;
import com.kademika.day10.domain.Car;
import com.kademika.day10.domain.Porshe911;

public class CarBoxDemo {

    public static void main(String[] args) {
        CarBox<Car> cars = new CarBox<>();
        CarBox<Porshe911> porshe911 = new CarBox<>();
        CarBox<NissanQashqai> nissanQashqai = new CarBox<>();

//        cars.addCar(porshe911); //why not applied ???
//        cars.addCar(nissanQashqai);  //why not applied ???
        cars.addCar(new Porshe911("Porshe", "911", 1000000));
        cars.addCar(new NissanQashqai("Nissan", "Qashqai", 28280.5));

        for (Car car : cars.getCars()) {
            System.out.println(car.getBrand());
        }

//        CarBox<Integer> ints = new CarBox<>(); // will not compile
    }
}
