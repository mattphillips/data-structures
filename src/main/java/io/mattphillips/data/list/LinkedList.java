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
		
		if (nodes == null) 
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
	}

	@Override
	public int size() {
		return 0;
	}

}