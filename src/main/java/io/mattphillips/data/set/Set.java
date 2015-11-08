package io.mattphillips.data.set;

import java.util.Collection;

public interface Set<E> {

	boolean add(E element);
	
	boolean addAll(Collection<? extends E> c);
	
	boolean contains(E value);
	
	boolean isEmpty();
}