package com.kademika.day10.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ClassReflection {
	
    public static <T> void printClassInfo(Class<T> c) {
        System.out.println("Class: " + c.getName());
    }

    public static <T> void printClassMethods(Class<T> c) {
        Method[] methods = c.getDeclaredMethods();
        System.out.println("=========================================");
        System.out.println("Methods of the class " + c.getSimpleName() + " (qty = " + methods.length + ") :");
        for (Method m : methods) {
            System.out.println("Name: " + m.getName() + ", Return type: " + m.getReturnType().getName());
        }
    }

    public static <T> void printClassFields(Class<T> c) {
        Field[] fields = c.getDeclaredFields();
        System.out.println("=======================================");
        System.out.println("Fields of the class " + c.getSimpleName() + " (qty = " + fields.length + ") :");
        for (Field f : fields) {
            System.out.println("Name: " + f.getName() + ", Field type: " + f.getType().getName());
        }
    }
    
    public<T> T initClass(Class<T> c, Map<String, Object> params) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
    	T cInst = c.newInstance();
    	
    	Field[] fields = cInst.getClass().getFields(); //we get only public fields
    	for(Field f : fields) {
    		if (params.containsKey(f.getName())) {
    			f.set(cInst, params.get(f.getName()));
    			System.out.println(c.getSimpleName() 
    			+ " init... by initClass(Class, Map<String, Object>): " 
    			+ cInst.getClass().getField(f.getName()) + " = "
    			+ f.get(cInst));
    		}
    	}
        return cInst;
    }
    
    public <T> T initClass(Class<T> c, List<Object> params) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {    	
    	Constructor[] constructors = c.getConstructors(); //we get only public constructors
    	for(Constructor cnstr : constructors) {
    		Class[] paramTypes = cnstr.getParameterTypes();
    		
    		if(params.toArray().length == paramTypes.length) { // (?) what checking should use? instanceof
    			Object cInst = cnstr.newInstance(params.toArray());
    			
    			Field[] fields = cInst.getClass().getDeclaredFields(); //we get all fields for visualization
    	    	for(Field f : fields) {
    	    		f.setAccessible(true); //for getting access to value of private field below
    	    		System.out.println(c.getSimpleName()
    	    		+ " init... by initClass(Class, List<Object>): "
        			+ cInst.getClass().getDeclaredField(f.getName()) + " = "
        			+ f.get(cInst));
    	    	}
    			return (T) cInst;
    		}
    	}
    	
		return null;
    }
    
    public void setPrivates(Object obj, Map<String, Object> params) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    	Field[] fields = obj.getClass().getDeclaredFields(); //we get all fields including private
    	
    	for(Field f : fields) {
    		if (params.containsKey(f.getName())) {
    			f.setAccessible(true); //for getting access to private field
    			f.set(obj, params.get(f.getName()));
    			System.out.println(obj.getClass().getSimpleName() + " init... parameters: " 
    			+ obj.getClass().getDeclaredField(f.getName()) + " = "
    			+ f.get(obj));
    		}
    	}
    }
}