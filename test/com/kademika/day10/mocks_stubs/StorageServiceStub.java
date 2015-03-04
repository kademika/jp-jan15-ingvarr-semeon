package com.kademika.day10.mocks_stubs;

import java.util.List;

//Stub object for StorageService
public class StorageServiceStub implements StorageService {

	@Override
	public <T> void store(T object) {
		// TODO Auto-generated method stub
	}

	@Override
	public <T> T getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
