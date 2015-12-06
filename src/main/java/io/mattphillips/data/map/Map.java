package io.mattphillips.data.map;

public interface Map <K, V> {

	boolean put(K key, V value);
	
	boolean contains(K key);
	
	boolean isEmpty();
	
	int size();
	
	boolean remove(K key);
	
	void clear();
}