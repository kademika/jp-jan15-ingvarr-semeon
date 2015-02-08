package com.kademika.day10.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

    public T initClass(Class c, Map<String, Object> obj) {
        Class<?> aClass = c.getClass();

        System.out.println("A class " + aClass.getName() + " was initialized");

        return null;
    }
}