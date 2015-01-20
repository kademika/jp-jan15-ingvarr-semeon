package com.kademika.day10.generics.wildcards;

import com.kademika.day10.domain.AudiA4AQ;
import com.kademika.day10.domain.Car;
import com.kademika.day10.domain.Porshe911;

public class CarBoxDemo {

    public static void main(String[] args) {
        CarBox<Car> products = new CarBox<>();
        CarBox<Porshe911> porshe911 = new CarBox<>();
        CarBox<AudiA4AQ> audiA4 = new CarBox<>();

//        CarBox<Integer> ints = new CarBox<>(); // will not compile
    }
}
