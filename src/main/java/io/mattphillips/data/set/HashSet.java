package io.mattphillips.data.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashSet<E> implements Set<E> {
	
	private static final Object PRESENT = new Object();
	private Map<E, Object> map;
	
	public HashSet() {
		map = new HashMap<>();
	}

	@Override
	public boolean add(E element) {
		return map.put(element, PRESENT) == null;
	}

	@Override
	public boolean contains(E value) {
		return map.containsKey(value);
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		boolean modified = false;
		for (E element : c) {
			if(add(element))
				modified = true;
		}
		return modified;
	}

}