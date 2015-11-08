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
	
}