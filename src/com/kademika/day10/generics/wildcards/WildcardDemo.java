package com.kademika.day10.generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class WildcardDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3});
        print(numbers); //compilation error without wildcard '?'

        List<Long> longs = Arrays.asList(new Long[]{1L, 2L, 3L});
        print(longs); //compilation error without wildcard '?'

//        List<String> strings = Arrays.asList(new String[]{"1Str", "2Str", "3Str"});
//        print(strings); //compilation error: String not extends Number
    }

    private static void print(List<? extends Number> numbers) { // '?' - wildcard

        for (Number n : numbers) {
            System.out.println(n);
        }
    }
}
