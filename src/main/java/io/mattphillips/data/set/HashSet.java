package io.mattphillips.data.set;

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

}