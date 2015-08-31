package io.mattphillips.data.stack;

import java.util.EmptyStackException;

import io.mattphillips.data.Node;

public class MyStack<T> implements Stack<T> {

	private Node<T> top = null;
 
	@Override
	public T pop() {
		
		if (top == null) 
			throw new EmptyStackException();

		Node<T> previousTop = top;
		top = previousTop.getNext();

		return previousTop.getData();
	}

	@Override
	public void push(T item) {
		
		Node<T> newTop = new Node<>(item, top);
		top = newTop;
	}

	@Override
	public T peek() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
	
} 