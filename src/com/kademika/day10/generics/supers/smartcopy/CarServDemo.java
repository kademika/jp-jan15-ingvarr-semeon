package com.kademika.day10.generics.supers.smartcopy;

import com.kademika.day10.domain.Car;
import com.kademika.day10.domain.KIASportage;
import com.kademika.day10.domain.NissanQashqai;

import java.util.ArrayList;
import java.util.List;

public class CarServDemo {

    public static void main(String[] args) {

        List<KIASportage> kiaSportageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            kiaSportageList.add(new KIASportage());
        }

        List<NissanQashqai> nissanQashqaiList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nissanQashqaiList.add(new NissanQashqai());
        }

        List<Car> cars = new ArrayList<>();

        CarServ.copy(kiaSportageList, cars);
        CarServ.copy(nissanQashqaiList, cars);

        List<Object> obj = new ArrayList<>();
        CarServ.copy(kiaSportageList, obj);

//        CarServ.copy(kiaSportageList, nissanQashqaiList); //wrong 2nd argument: required List<? super Car>
    }
}
