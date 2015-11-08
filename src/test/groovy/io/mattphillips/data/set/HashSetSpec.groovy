package io.mattphillips.data.set

import spock.lang.Specification

class HashSetSpec extends Specification {
	
	def "Should be able to instaniate a new HashSet with an existing collection"() {
		given: "a collection with some values"
		
		def list = Arrays.asList("Hello", "World")
		
		when: "a HashSet is created with the collection"
		Set<String>	s = new HashSet<>(list);
		
		then: "the set should contain all unique values from the collection"
		s.contains("Hello") == true
		s.contains("World") == true
	}
	
	def "Should add a unique string to the set"() {
		
		given: "a set of type string"
		Set<String>	s = new HashSet<>();
		
		when: "a string is added to the set"
		def actual = s.add("Hello world!")
		
		then: "true should be returned when the string is successfully added"
		actual == true
	}
	
	def "Should not add a value to the set when the set already contains the value"() {
		
		given: "a set of type string"
		Set<String>	s = new HashSet<>();
		
		when: "the same value is added twice"
		s.add("Hello world!")
		def actual = s.add("Hello world!")
		
		then: "false should be returned when attempting to add the same value for a second time"
		actual == false
	}
	
	def "Should return true when a set contains a given value"() {
		
		given: "a set of strings containing 'Hello world!'"
		Set<String>	s = new HashSet<>();
		s.add("Hello world!")
		
		when: "checked to see if set contains a value"
		def actual = s.contains(value);
		
		then: "true should be returned if the set has the value"
		actual == expected
		
		where:
		value          | expected
		"Hello world!" | true
		"Goodbye"      | false
	}
	
	def "Should return true if the set is empty"() {
	
		given: "an empty set"
		Set<String>	s = new HashSet<>();
		
		when: "is empty is called"
		def actual = s.isEmpty() 
				
		then: "result should be true"
		actual == true
	}
	
	def "Should return false if the set is not empty"() {
		
		given: "a non empty set"
		Set<String>	s = new HashSet<>();
		s.add("Hello world!")
		
		when: "is empty is called"
		def actual = s.isEmpty()
				
		then: "result should be false"
		actual == false
	}
	
	def "Should add all of the elements of a collection to the set if they are not already present"() {
		
		given: "an empty set and a collection of values"
		Set<String>	s = new HashSet<>();
		List<String> list = Arrays.asList(elements)
		
		when: "add all is called with the collection"
		def actual = s.addAll(list)
		
		then: "all elements should be added to the set"
		actual == expected
		
		where:
		elements        | expected
		["a", "b", "c"] | true
		["a", "a", "a"] | true
	}
	
	def "Should not add elements of a collection to the set that are present"() {
		
		given: "a set with one value and a collection of the same value"
		Set<String>	s = new HashSet<>();
		s.add("a")
		List<String> list = Arrays.asList("a")
		
		when: "add all is called with the collection"
		def actual = s.addAll(list)
		
		then: "nothing should be added to the set"
		actual == false
	}
	
	def "Should return size of set"() {
		
		given: "a set of elements"
		Set<String>	s = new HashSet<>(Arrays.asList("Hello", "world"))
		
		when: "size is called"
		def actual = s.size()
		
		then: "the number of elements within the set should be returned"
		actual == 2
	}
}