package com.kademika.day10.generics.basics.method;

import java.util.Arrays;
import java.util.List;

public class GenericMethodDemo {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(new String[]{"one", "two", "three"});
        print(strings);

        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3});
        print(numbers);

        List<Object> objects = Arrays.asList(new Object[]{"one", 2, "three", 4.0, true});
        print(objects);
    }

    //Generalized method
    public static <E> void print(List<E> elements) {
        for (E e : elements) {
            System.out.println(e.toString());
        }
    }
}
