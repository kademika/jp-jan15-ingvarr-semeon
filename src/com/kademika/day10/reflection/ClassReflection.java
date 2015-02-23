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
    		}
    	}
        return cInst;
    }
    
    public <T> T initClass(Class<T> c, List<Object> params) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {    	
    	Constructor[] constructors = c.getConstructors(); //we get only public constructors
    	
    	for(Constructor cnstr : constructors) {
    		
    		Class[] paramTypes = cnstr.getParameterTypes();
    		
    		if(params.toArray().length == paramTypes.length) {
    			
//    			//New instance creation via suitable constructor (by means of length only):
//    			Object cInst = cnstr.newInstance(params.toArray());
    			
    			// (!) Realization via instanceof:
    			Object cInst = null;
    			
    			//New instance creation via suitable constructor:
    			if (params.toArray().length == 0) {
    				cInst = cnstr.newInstance();
    			} else if (params.toArray().length == 2) {
    				if (params.toArray()[0] instanceof String 
    					&& params.toArray()[1] instanceof Integer ) {
    					cInst = cnstr.newInstance(params.toArray()[0], params.toArray()[1]);
        			}
    			} else if (params.toArray().length == 3) {
    				if (params.toArray()[0] instanceof String 
    					&& params.toArray()[1] instanceof Double
    					&& params.toArray()[2] instanceof Integer ) {
    					cInst = cnstr.newInstance(params.toArray()[0]
    											, params.toArray()[1]
    											, params.toArray()[2]);
    				}
    			} else if (params.toArray().length == 5) {
    				if (params.toArray()[0] instanceof String 
        					&& params.toArray()[1] instanceof Double
        					&& params.toArray()[2] instanceof Integer
        					&& params.toArray()[3] instanceof String
        					&& params.toArray()[4] instanceof Integer) {
        					cInst = cnstr.newInstance(params.toArray()[0]
        											, params.toArray()[1]
        											, params.toArray()[2]
        											, params.toArray()[3]
        											, params.toArray()[4]);
        				}
    			}
    			
    			try {
    				return (T) cInst;
    			} catch (NullPointerException e) {
    				System.out.println("Suitable constructor for class " + c.getSimpleName() + " was not found ");
    			}
    		}
    	}
		return null;
    }
    
    public void setPrivates(Object obj, Map<String, Object> params) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
    	Field[] fields = obj.getClass().getDeclaredFields(); //we get all fields including private
    	
    	for(Field f : fields) {
    		if (params.containsKey(f.getName())) {
    			
    			//For getting access (get & set) to private field:
    			f.setAccessible(true);
    			f.set(obj, params.get(f.getName()));
//    			
//    			System.out.println(obj.getClass().getSimpleName() + " init... parameters: " 
//    			+ obj.getClass().getDeclaredField(f.getName()) + " = "
//    			+ f.get(obj));
    		}
    	}
    }
}