package com.kademika.day10.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ClassReflection<T> {
	
    public static void printClassInfo(Class c) {
        System.out.println("Class: " + c.getName());
    }

    public static void printClassMethods(Class c) {
        Method[] methods = c.getMethods();
        System.out.println("=========================================");
        System.out.println("Methods of the class " + c.getSimpleName() + " (qty = " + methods.length + ") :");
        for (Method m : methods) {
            System.out.println("Name: " + m.getName() + ", Return type: " + m.getReturnType().getName());
        }
    }

    public static void printClassFields(Class c) {
        Field[] fields = c.getFields();
        System.out.println("=======================================");
        System.out.println("Fields of the class " + c.getSimpleName() + " (qty = " + fields.length + ") :");
        for (Field f : fields) {
            System.out.println("Name: " + f.getName() + ", Field type: " + f.getType().getName());
        }
    }
    
    public T initClass(Class c, Map<String, Object> obj) throws IllegalAccessException, InstantiationException {
        Object classInstance = c.newInstance();
        
        for (Field field : classInstance.getClass().getDeclaredFields()) {
            if (obj.containsKey(field.getName())) {
                field.set(obj, obj.get(field.getName()));
            } else {
                System.out.println("Field: " + field.getName() + " was not initialized");
            }
        }
        System.out.println(classInstance.toString());
        System.out.println("A class " + c.getSimpleName() + " was initialized by initClass(Class, Map<String, Object>)");
        
        return (T) classInstance;
    }
    
    public T initClass(Class c, List<Object> listObjects) throws NoSuchMethodException, SecurityException {
		Object classInstance = c.getConstructor(c);
		
    	System.out.println(classInstance.toString());
    	System.out.println("A class " + c.getSimpleName() + " was initialized by initClass(Class, List<Object>)");
		
		return (T) classInstance;
    }
}