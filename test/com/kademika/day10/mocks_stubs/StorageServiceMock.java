package com.kademika.day10.mocks_stubs;

import java.util.ArrayList;
import java.util.List;

//Mock object for StorageService
public class StorageServiceMock implements StorageService {

    private List<Object> objects;

    private int storeCounter;

    public StorageServiceMock() {
        this.objects = new ArrayList<>();
        storeCounter = 0;
    }

    @Override
    public <T> void store(T object) {
        storeCounter++;
        objects.add(object);
    }

    @Override
    public <T> T getByID(Long id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        return (List<T>) new ArrayList<>(objects);
    }

    public int getStoreCounter() {
        return storeCounter;
    }
}
