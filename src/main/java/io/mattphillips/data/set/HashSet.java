package io.mattphillips.data.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashSet<E> implements Set<E> {
	
	private static final Object PRESENT = new Object();
	private transient Map<E, Object> map;
	
	public HashSet() {
		map = new HashMap<>();
	}
	
	public HashSet(final Collection<? extends E> c) {
		map = new HashMap<>(c.size());
		addAll(c);
	}

	@Override
	public boolean add(final E element) {
		return map.put(element, PRESENT) == null;
	}

	@Override
	public boolean contains(final E value) {
		return map.containsKey(value);
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean addAll(final Collection<? extends E> c) {
		
		boolean modified = false;
		for (E element : c) {
			if(add(element))
				modified = true;
		}
		return modified;
	}

	@Override
	public int size() {
		return map.size();
	}

}