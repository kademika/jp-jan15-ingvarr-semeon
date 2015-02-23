package com.kademika.day10.generics.servicerepository;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository<T extends Service> {

    private List<T> serviceList;

    public ServiceRepository() {
        serviceList = new ArrayList<>();
    }

    public void addService(T obj) {
        serviceList.add(obj);
    }

    public void remomeService(T obj) {
        serviceList.remove(obj);
    }

    public void remove(int index) {
        serviceList.remove(index);
    }

    public T get(int index) {
        return serviceList.get(index);
    }

    public void set(int index, T service) {
        serviceList.set(index, service);
    }

    public List<T> getAllService() {
        return serviceList;
    }
}