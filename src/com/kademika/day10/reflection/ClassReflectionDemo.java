package com.kademika.day10.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ClassReflectionDemo {

    public static void main(String[] args) 
    		throws InstantiationException
    				, IllegalAccessException
    				, NoSuchMethodException
    				, SecurityException, IllegalArgumentException, NoSuchFieldException, InvocationTargetException {
//        ClassReflection.printClassInfo(DemoClass.class);
//        ClassReflection.printClassMethods(DemoClass.class);
//        ClassReflection.printClassFields(DemoClass.class);
        
        Map map = new HashMap<String, Object>();
//        map.put("name", "DemoClass"); //java.lang.IllegalAccessException
//        map.put("version", 1.0); //java.lang.IllegalAccessException
//        map.put("prodactionYear", 2015); //java.lang.IllegalAccessException
        map.put("nickName", "DemoNick");
        
        List list = new ArrayList();
        list.add("DemoClass");
        list.add(1.0);
        list.add(2015);
        list.add("DemoNick2");
        
        ClassReflection cr = new ClassReflection();
        cr.initClass(DemoClass.class, map);
        cr.initClass(DemoClass.class, list);
    }
}
