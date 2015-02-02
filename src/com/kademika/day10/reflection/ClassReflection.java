package com.kademika.day10.reflection;

import java.lang.reflect.Method;

public class ClassReflection {

    public static void printClassInfo(Class c) {
        System.out.println("Class: " + c.getName());
    }

    public static void printClassMethods(Class c) {
        Method[] methods = c.getMethods();
        System.out.println("Methods of the class " + c.getSimpleName() + " (qty = " + methods.length + ") :");
        for (Method m : methods) {
            System.out.println("Name: " + m.getName() + ", Return type: " + m.getReturnType().getName());
        }
    }

    public static void printClassFields(Class c) {
    }
}