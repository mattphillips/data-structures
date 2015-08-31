package io.mattphillips.data.stack

import spock.lang.Specification

class MyStackSpec extends Specification {

	def "Should throw exception when performing pop on an empty stack"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling pop"
		stack.pop()
		
		then: "An empty stack exception is thrown"
		final EmptyStackException exception = thrown()
	}
	
	def "Should return top item in stack and set top to be returned item's next node"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling pop after pushing an item"
		stack.push("TOP")
		def item = stack.pop()
		
		then: "Item should be equal to top data and top should be null"
		item      == "TOP"
		stack.top == null
	}
	
	def "Should add new items to the top of the stack"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling pop"
		stack.push("TOP")
		
		then: "Item should be equal to top data"
		stack.top.getData() == "TOP"
		stack.top.getNext() == null
	}
	
	def "Should add new items to the top of the stack and move existing items to the next of the top"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling pop"
		stack.push("TOP")
		stack.push("NEW TOP")
		
		then: "Item should be equal to top data"
		stack.top.getData() == "NEW TOP"
		stack.top.getNext() != null
	}
	
	def "Should return true if the stack is empty"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling is empty"
		def empty = stack.isEmpty()
		
		then: "should be true"
		empty == true
	}
	
	def "Should return false if the stack is not empty"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling is empty after pushing into the stack"
		stack.push("not empty")
		def empty = stack.isEmpty()
		
		then: "should be false"
		empty == false
	}
	
	def "Should throw exception when performing peek on an empty stack"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "calling peek"
		stack.peek()
		
		then: "An empty stack exception is thrown"
		final EmptyStackException exception = thrown()
	}
	
	def "Should return the top item in a stack"() {
		
		given: "An empty Stack"
		def stack = new MyStack()
		
		when: "adding an item and calling peek"
		stack.push("Hello, World!")
		def item = stack.peek()
		
		then: "The item should be returned"
		item == "Hello, World!"
	}
}