package com.kademika.day10.reflection;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ClassReflectionDemo {

    public static void main(String[] args) 
    		throws InstantiationException
    				, IllegalAccessException
    				, NoSuchMethodException
    				, SecurityException {
        
    	ClassReflection.printClassInfo(DemoClass.class);
        ClassReflection.printClassMethods(DemoClass.class);
        ClassReflection.printClassFields(DemoClass.class);
        
        Map map = new HashMap<String, Object>();
        map.put("name", "DemoClass");
        map.put("version", 1.0);
        map.put("year", 2015);
        
        List list = new ArrayList();
        list.add("nickName");
        
        ClassReflection cr = new ClassReflection();
        
        cr.initClass(DemoClass.class, map);
        cr.initClass(DemoClass.class, list);
    }
}
