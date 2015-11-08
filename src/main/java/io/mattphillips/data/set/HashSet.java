package io.mattphillips.data.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

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

	public boolean add(final E element) {
		return map.put(element, PRESENT) == null;
	}

	public boolean contains(final E value) {
		return map.containsKey(value);
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean addAll(final Collection<? extends E> c) {
		
		boolean modified = false;
		for (E element : c) {
			if(add(element))
				modified = true;
		}
		return modified;
	}

	public int size() {
		return map.size();
	}
	
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}
	
	public boolean remove(E e) {
		return map.remove(e) == PRESENT;
	}

}