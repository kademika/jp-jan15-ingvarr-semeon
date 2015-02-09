package com.kademika.day10.reflection;

import java.util.HashMap;
import java.util.Map;

public class ClassReflectionDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassReflection.printClassInfo(Integer.class);
        ClassReflection.printClassMethods(Integer.class);
        ClassReflection.printClassFields(Integer.class);


        Map map = new HashMap<String, Object>();
        map.put("nickName", "Reflex");
        map.put("version", 1.0);
        map.put("year", 2015);

        ClassReflection cr = new ClassReflection();
        cr.initClass(ClassReflection.class, map);
    }
}
