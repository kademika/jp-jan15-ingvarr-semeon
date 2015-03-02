package com.kademika.day10.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApplicationManager {

    public static <T> T getService(Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T service = null;

        //check for @Service annotation presence in class:
        if (clazz.isAnnotationPresent(Service.class)) {
            service = clazz.newInstance();

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                //check method with @InitService annotation:
                if (method.isAnnotationPresent(InitService.class)) {
                    //Class initialization:
                    method.invoke(service);
                }
            }
        }
        return service;
    }
}
