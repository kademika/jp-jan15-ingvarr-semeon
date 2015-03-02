package com.kademika.day10.annotation;

import java.lang.reflect.InvocationTargetException;

public class Launcher {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SomeClass someClass = ApplicationManager.getService(SomeClass.class);
        System.out.println(someClass);

        ServiceClass serviceClass = ApplicationManager.getService(ServiceClass.class);
        System.out.println(serviceClass.getName() + " produced in " + serviceClass.getProdYear());
    }
}
