package com.kademika.day10.annotation;

import java.lang.annotation.Annotation;

public class ApplicationManager {

    public static <T> T getService(Class<T> clazz) {

        for (Annotation annotation : clazz.getAnnotations()) {
            //check for @Service annotation using
            if (annotation.annotationType() == Service.class) { //if (annotation instanceof Service)
//                Class initialization:

                //if is annotation @Init should run
            }
        }

        return null;
    }
}
