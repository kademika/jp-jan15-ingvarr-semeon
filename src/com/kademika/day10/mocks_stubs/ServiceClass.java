package com.kademika.day10.mocks_stubs;

import java.util.Map;

public class ServiceClass {

    private StorageService storageService;

    public void storeUserData(Map<String, Object> data) {
        storageService.store(data);
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
