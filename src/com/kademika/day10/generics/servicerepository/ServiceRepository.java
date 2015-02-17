package com.kademika.day10.generics.servicerepository;

import java.util.List;

public class ServiceRepository {
	
	private List<Service> services;

	public List<Service> getAllServices() {
		return services;
	}

	public void addService(Class<Service> tClass) throws IllegalAccessException, InstantiationException {
		Service cls = tClass.newInstance();

	}

    public Service getService(Class<Service> tClass) {

        return null;
    }
	
}