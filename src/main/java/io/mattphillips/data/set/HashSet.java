package io.mattphillips.data.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashSet<T> implements Set<T> {
	
	private static final Object PRESENT = new Object();
	private Map<T, Object> elements;
	
	public HashSet() {
		elements = new HashMap<>();
	}

	@Override
	public boolean add(T element) {
		return elements.put(element, PRESENT) == null;
	}

	@Override
	public boolean contains(T value) {
		return elements.containsKey(value);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		boolean modified = false;
		for (T element : c) {
			if(add(element))
				modified = true;
		}
		return modified;
	}

}