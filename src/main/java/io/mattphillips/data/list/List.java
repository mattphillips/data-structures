package io.mattphillips.data.list;

public interface List<T> {

	void add(T data);
	
	T get(int index);
	
	void remove(int index);
	
	int size();
}