package io.mattphillips.data.set;

public interface Set<T> {

	boolean add(T element);
	
	boolean contains(T value);
	
	boolean isEmpty();
}