package com.kademika.day10.generics.basics.box;

import java.util.Arrays;

public class BoxDemo {

    public static void main(String[] args) {
        Box<Double> box = new Box<>();
        Box<String> boxic = new Box<>();
        Box<Integer[]> bigBox = new Box<>();

        box.setItem(10.0);
        boxic.setItem("ten");

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        bigBox.setItem(array);

        System.out.println(box.getItem() + " = " + boxic.getItem());
        System.out.println(Arrays.toString(bigBox.getItem()));
    }
}
