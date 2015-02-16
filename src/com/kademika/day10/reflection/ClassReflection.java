package com.kademika.day10.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ClassReflection<T> {
	
    public static void printClassInfo(Class c) {
        System.out.println("Class: " + c.getName());
    }

    public static void printClassMethods(Class c) {
        Method[] methods = c.getDeclaredMethods();
        System.out.println("=========================================");
        System.out.println("Methods of the class " + c.getSimpleName() + " (qty = " + methods.length + ") :");
        for (Method m : methods) {
            System.out.println("Name: " + m.getName() + ", Return type: " + m.getReturnType().getName());
        }
    }

    public static void printClassFields(Class c) {
        Field[] fields = c.getDeclaredFields();
        System.out.println("=======================================");
        System.out.println("Fields of the class " + c.getSimpleName() + " (qty = " + fields.length + ") :");
        for (Field f : fields) {
            System.out.println("Name: " + f.getName() + ", Field type: " + f.getType().getName());
        }
    }
    
    public T initClass(Class c, Map<String, Object> params) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
    	Object cInst = c.newInstance();
    	
    	Field[] fields = c.getDeclaredFields();
    	for(Field f : fields) {
    		if (params.containsKey(f.getName())) {
    			f.set(cInst, params.get(f.getName()));
    		}
    	}
        System.out.println("A class " + c.getSimpleName() + " was initialized by initClass(Class, Map<String, Object>)");
        
        return (T) cInst;
    }
    
    public T initClass(Class c, List<Object> params) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//    	Object cInst = c.newInstance();
    	
    	Constructor[] constructors = c.getConstructors();
    	for(Constructor cnstr : constructors) {
    		Class[] paramTypes = cnstr.getParameterTypes();
    		if(params.equals(paramTypes)) {
    			Object cInst = cnstr.newInstance(params);
    			
    			System.out.println("A class " + c.getSimpleName() + " was initialized by initClass(Class, List<Object>)");
    			
    			return (T) cInst;
    		}
    	}
    	
		return null;
    }
}