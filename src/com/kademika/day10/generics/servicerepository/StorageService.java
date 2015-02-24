package com.kademika.day10.generics.servicerepository;

import java.util.List;

public interface StorageService {
	
	public <T> T store (T object);
	
	public <T> T getByID(Long id);
	
	public <T> List<T> getAll(Class<T> clazz);
}