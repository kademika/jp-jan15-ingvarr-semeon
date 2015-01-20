package com.kademika.day10.generics.basics.rules;

import java.util.ArrayList;
import java.util.List;

public class TrickyLists {
    public static void main(String[] args) {
//        List data = new ArrayList(); //should generalize via <Type> declaration
        List<Integer> data = new ArrayList();
        List<String> strList = new ArrayList<>();

//        data = strList; //both types are generalized via <Type> declaration: incompatibles variables
        data.add(10);

        String s = strList.get(0); //ClassCastException
    }
}
