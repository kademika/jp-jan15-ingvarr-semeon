package com.kademika.day10.reflection;

public class ClassReflectionDemo {

    public static void main(String[] args) {
        ClassReflection.printClassInfo(Integer.class);
        ClassReflection.printClassMethods(Integer.class);
    }
}
