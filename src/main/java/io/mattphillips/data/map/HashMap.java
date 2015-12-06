package io.mattphillips.data.map;

public class HashMap<K, V> implements Map<K, V> {
	
	private static final int DEFAULT_SIZE = 100;
	
	transient Node<K, V>[] table;
	private int size = 0;
	
	public HashMap() {
		table = (Node<K,V>[])new Node[DEFAULT_SIZE];
	}

	@Override
	public boolean put(K key, V value) {
		
		Node<K,V> n = table[hash(key)];
		
		if (contains(key))
			return false;
		
		if (n == null) {
			table[hash(key)] = new Node(key, value, hash(key), null);
			size++;
			return true;
		
		} else {
			
			while(n != null) {
				n = n.next;
			}
			
			n.next = new Node(key, value, hash(key), null);
			size++;
			return true;
		}
	}
	
	private int hash(K key) {
		return key.hashCode() % DEFAULT_SIZE;
	}

	@Override
	public boolean contains(K key) {
		
		Node<K, V> n = table[hash(key)];
		
		if (n != null) {
			while(n != null) {
				if (n.key.equals(key)) {
					return true;
				}
				n = n.next;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean remove(K key) {
		
		if (!contains(key))
			return false;
		
		Node<K, V> n = table[hash(key)];
		
		if (n.next == null) {
			table[hash(key)] = null;
			size--;
			return true;
		
		} else {
			Node<K,V> parent = n;
			n = n.next;
			while(n != null) {
				if (n.key.equals(key)) {
					parent.next = null;
					size--;
					return true;
				}
				parent = n;
				n = n.next;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		table = null;
		size = 0;
		table = (Node<K,V>[])new Node[DEFAULT_SIZE];
	}
	
	private class Node<K, V> {
		
		private final K key;
		private final V value;
		private final int hash;
		private Node<K, V> next;
		
		public Node(final K key, final V value, final int hash, final Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}
		
		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public int getHash() {
			return hash;
		}

		public Node<K, V> getNext() {
			return next;
		}

	}

}
