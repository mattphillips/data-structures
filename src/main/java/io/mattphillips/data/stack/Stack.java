package io.mattphillips.data.stack;

public interface Stack<T> {

	// Remove the top item from the stack
	public T pop();

	// Add item to the top of the stack
	public void push(T item);

	// Return the top of the stack
	public T peek();

	// Return true if and only if the stack is empty
	public boolean isEmpty();
}