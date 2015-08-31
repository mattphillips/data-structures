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
	
	
}