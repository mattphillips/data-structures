package io.mattphillips.data.list;

public interface List<T> {

	boolean add(T data);
	
	T get(int index);
	
	boolean remove(int index);
	
	int size();
}