package io.mattphillips.data.list

import spock.lang.Specification

class LinkedListSpec extends Specification {
	
	def "Should add first node to the head of the list"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Adding a new node"
		list.add("Hello")
		
		then: "The head node data should equal the added value and the next node should be null"
		list.nodes.data      == "Hello"
		list.nodes.next == null
	}

	def "Should add new nodes to the last node"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when:
		list.add("Hello")
		list.add("World")
		list.add("!")
		
		then:
		list.nodes.data           == "Hello"
		list.nodes.next.data      == "World"
		list.nodes.next.next.data == "!"
	}
	
	def "Should throw index out of bounds exception when list is empty"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Get is called on empty list"
		list.get(0)
		
		then: "An index out of bounds exception is thrown"
		final IndexOutOfBoundsException exception = thrown()
	}
	
	def "Should throw index out of bounds exception when index is larger than list size" () {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Get is called with an index greater than the size of the list"
		list.add("Zero")
		list.get(1)
		
		then: "An index out of bounds exception is thrown"
		final IndexOutOfBoundsException exception = thrown()
	}
	
	def "Should return value at given index"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Adding new data"
		list.add("A")
		list.add("B")
		list.add("C")
		
		then: 
		list.get(index) == value
		
		where:
		index | value
		0     | "A"
		1     | "B"
		2     | "C"
	}
	
	
}