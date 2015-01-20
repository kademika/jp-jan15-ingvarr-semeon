package com.kademika.day10.generics.basics.box;

import java.util.ArrayList;
import java.util.List;

public class RegularBoxDemo {

    public static void main(String[] args) {
        List data = new ArrayList<>();

        data.add(1);
        data.add(2);
        data.add(4);
        data.add("seven");

        int sum = 0;
        for (Object o : data) {
            if (o instanceof Integer) {
                sum += (Integer) o;
            }
        }

        System.out.println(sum);
    }

}
