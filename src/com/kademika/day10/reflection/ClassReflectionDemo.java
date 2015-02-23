package com.kademika.day10.reflection;

import java.lang.reflect.Field;
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
        
        ClassReflection cr = new ClassReflection();
    	
        //Map of parameters creation and filling:
        Map map = new HashMap<String, Object>();
        map.put("name", "DemoClass"); //private
        map.put("version", 1.0); //private
        map.put("prodactionYear", 2015); //private
        map.put("nickName", "DemoNick"); //public
        map.put("score", 7); //public
        
        //Here method initClass will initialize only public fields in cInst:
        DemoClass cInst = cr.initClass(DemoClass.class, map);
        
        //Output of result:
    	Field[] fields = cInst.getClass().getDeclaredFields();
    	for(Field f : fields) {
    		f.setAccessible(true);
			System.out.println(cInst.getClass().getSimpleName() 
								+ " init... by initClass(Class, Map<String, Object>): " 
								+ cInst.getClass().getDeclaredField(f.getName()) + " = "
								+ f.get(cInst));
    	}
    	
    	//Method setPrivates will initialize private fields in cInst:
    	cr.setPrivates(cInst, map);
    	
    	//Output of result:
    	Field[] fields2 = cInst.getClass().getDeclaredFields();
    	for(Field f : fields2) {
			f.setAccessible(true);
			System.out.println(cInst.getClass().getSimpleName() + " init... parameters: " 
								+ cInst.getClass().getDeclaredField(f.getName()) + " = "
								+ f.get(cInst));
    	}
        
    	//List of parameters creation and filling:
        List list = new ArrayList();
        list.add("DemoClass");
        list.add(1.0);
        list.add(2015);
        list.add("DemoNick2");
        list.add(8);
        
        //Here method initClass will initialize all fields including private in cInst2:
        DemoClass cInst2 = cr.initClass(DemoClass.class, list);
        
        //Output of result:
        Field[] fields3 = cInst2.getClass().getDeclaredFields();
		for (Field f : fields3) {
			f.setAccessible(true);
	    	System.out.println(cInst2.getClass().getSimpleName()
	    						+ " init... by initClass(Class, List<Object>): "
	    						+ cInst2.getClass().getDeclaredField(f.getName()) + " = "
	    						+ f.get(cInst2));
		}
    }
}
