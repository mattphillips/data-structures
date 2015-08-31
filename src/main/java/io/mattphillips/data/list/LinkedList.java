package io.mattphillips.data.list;

public class LinkedList<T> implements List<T> {

	private Node<T> nodes = null;

	@Override
	public void add(T item) {

		Node<T> next = new Node<>(item, null);

		if (nodes == null) {
			nodes = next;

		} else {

			Node<T> current = nodes;
			while (current.getNext() != null)
				current = current.getNext();

			current.setNext(next);
		}
	}

	@Override
	public T get(int index) {
		
		if (nodes == null || index < 0) 
			throw new IndexOutOfBoundsException(String.valueOf(index));
		
		Node<T> current = nodes;
		for (int i = 0; i < index; i++) {
			
			if (current.getNext() != null)
				current = current.getNext();
			
			else 
				throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		
		return current.getData();
	}

	@Override
	public void remove(int index) {
		
		if (nodes == null || index < 0) 
			throw new IndexOutOfBoundsException(String.valueOf(index));
		
		Node<T> parent = null;
		Node<T> current = nodes;
		
		for (int i = 0; i < index; i++) {
			
			if (current.getNext() != null) {
				parent = current;
				current = current.getNext();
			
			} else {
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
		}
		
		if (parent == null) {
			nodes = null;
		
		} else {
			
			if (current.getNext() != null) {
				parent.setNext(current.getNext());
			
			} else {
				parent.setNext(null);
			}
		}
	}

	@Override
	public int size() {
		
		int size = 0;
		
		if (nodes == null) {
			return size;
		
		} else {
			
			Node<T> current = nodes;
			size++;
			
			while (current.getNext() != null) {
				size++;
				current = current.getNext();
			}
		}
		
		return size;
	}

}