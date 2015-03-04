package com.kademika.day10.mocks_stubs;

import java.util.List;

public interface StorageService {
	
	public <T> void store (T object);
	
	public <T> T getByID(Long id);
	
	public <T> List<T> getAll(Class<T> clazz);
}
