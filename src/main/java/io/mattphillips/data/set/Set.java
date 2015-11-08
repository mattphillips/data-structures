package io.mattphillips.data.set;

import java.util.Collection;

public interface Set<T> {

	boolean add(T element);
	
	boolean addAll(Collection<? extends T> c);
	
	boolean contains(T value);
	
	boolean isEmpty();
}