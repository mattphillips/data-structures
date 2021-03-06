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
	
	def "Should throw index out of bounds exception when trying to get an index on an empty list"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Get is called on empty list"
		list.get(0)
		
		then: "An index out of bounds exception is thrown"
		final IndexOutOfBoundsException exception = thrown()
	}
	
	def "Should throw index out of bounds exception when trying to get an index less than zero"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Get negative index"
		list.add("Hello")
		list.get(-1)
		
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
	
	def "Should return size 0 for an empty list"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Getting size"
		def size = list.size()
		
		then: "Size should be 0"
		size == 0
	}
	
	def "Should return size 1 when only one node has been added to the list"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Adding new data"
		list.add("A")
		
		then: "Size should be 1"
		list.size() == 1
	}
	
	def "Should return size of list when greater than 1"() {
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Adding 5 new pieces of data"
		list.add("A")
		list.add("B")
		list.add("C")
		list.add("D")
		list.add("E")
		
		then: "Size should be 5"
		list.size() == 5
	}
	
	def "Should throw index out of bounds exception when trying to remove an index from an empty list"() {
	
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Remove is called on an empty list"
		list.remove(0)
		
		then: "An index out of bounds exception is thrown"
		final IndexOutOfBoundsException exception = thrown()
	}
	
	def "Should throw index out of bounds exception when trying to remove a negative index"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Remove is called on at a negative index"
		list.add("A")
		list.remove(-1)
		
		then: "An index out of bounds exception is thrown"
		final IndexOutOfBoundsException exception = thrown()
	}
	
	def "Should throw index out of bounds when index is greater than the size of the list"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Remove is called on at a negative index"
		list.add("A")
		list.remove(5)
		
		then: "An index out of bounds exception is thrown"
		final IndexOutOfBoundsException exception = thrown()
	}
	
	def "Should set list nodes to null when removing only entry of the list"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Remove is called on only entry"
		list.add("A")
		list.remove(0)
		
		then: 
		
		list.size()  == 0
		list.nodes   == null
	}
	
	def "Should set parent node next to null when removing last element from a list of size 2"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Remove is called on last entry"
		list.add("A")
		list.add("B")
		list.remove(1)
		
		then:
		
		list.size()            == 1
		list.nodes.getNext()   == null
	}
	
	def "Should set parent node to remove node's next entry from a list of size greater than 2 when removing a middle entry"() {
		
		given: "An empty LinkedList"
		def list = new LinkedList()
		
		when: "Remove is called on middle entry"
		list.add("A")
		list.add("B")
		list.add("C")
		list.remove(1)
		
		then:
		
		list.size()                      == 2
		list.nodes.getNext().getData()   == "C"
	}
	
}