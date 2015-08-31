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
		return null;
	}

	@Override
	public void remove(int index) {
	}

	@Override
	public int size() {
		return 0;
	}

}