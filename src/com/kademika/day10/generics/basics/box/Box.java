package com.kademika.day10.generics.basics.box;

public class Box<T> {

    private T item;

    public Box() {
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
