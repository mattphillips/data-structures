package io.mattphillips.data.set

import spock.lang.Specification

class HashSetSpec extends Specification {
	
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
}