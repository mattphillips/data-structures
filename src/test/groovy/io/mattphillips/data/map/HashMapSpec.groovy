package io.mattphillips.data.map

import spock.lang.Specification

class HashMapSpec extends Specification {

	def "Should add key value to map"() {
		
		given: 
		Map<String, String> map = new HashMap<>();
		
		when:
		def actual = map.put("Matt", "Phillips")
		def actual2 = map.put("Matt", "Phillips")
		def actual3 = map.put("M", "Phillips")
		then:
		actual  == true
		actual2 == false
		actual3 == true
	}
	
	def "Should return the size of the map"() {
		given:
		Map<String, String> map = new HashMap<>();
		
		when:
		map.put("Matt", "Phillips")
		map.put("M", "Phillips")
		map.put("M2", "Phillips")
		map.remove("M2")
		
		def actual = map.size()
		
		then:
		actual  == 2
	}
	
	def "Should return true if the map contains the key"() {
		given:
		Map<String, String> map = new HashMap<>();
		
		when:
		map.put("Matt", "Phillips")
		map.put("M", "Phillips")
		
		then:
		map.contains("Matt") == true
		map.contains("M")    == true
		map.contains("M2")   == false
	}
	
	def "Should return true if the map is empty"() {
		given:
		Map<String, String> map = new HashMap<>();
		
		when:
		def actual = map.isEmpty()
		
		then:
		actual == true
	}
	
	def "Should return false if the map is not empty"() {
		given:
		Map<String, String> map = new HashMap<>();
		
		when:
		map.put("Matt", "Phillips")
		def actual = map.isEmpty()
		
		then:
		actual == false
	}
	
	def "Should clear the map"() {
		given:
		Map<String, String> map = new HashMap<>();
		
		when:
		map.put("Matt", "Phillips")
		map.put("M", "Phillips")
		map.clear()
		
		then:
		map.contains("Matt") == false
		map.contains("M")    == false
		map.isEmpty()        == true
	}
	
	
}
