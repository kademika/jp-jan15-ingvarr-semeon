package com.kademika.day10.mocks_stubs;

import java.util.List;

public class DbStorageService implements StorageService {

	@Override
	public <T> void store(T object) {
		//Realization should be here
	}

	@Override
	public <T> T getByID(Long id) {
		//Realization should be here
		return null;
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz) {
		//Realization should be here
		return null;
	}

}
