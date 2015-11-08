package io.mattphillips.data.set;

import java.util.Collection;
import java.util.Iterator;

public interface Set<E> {

	boolean add(E element);
	
	boolean addAll(Collection<? extends E> c);
	
	boolean contains(E value);
	
	boolean isEmpty();
	
	int size();
	
	Iterator<E> iterator();
	
	boolean remove(E e);
}