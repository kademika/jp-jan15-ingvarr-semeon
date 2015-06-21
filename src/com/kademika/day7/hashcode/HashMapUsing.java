package com.kademika.day7.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashMapUsing {

	public static void main(String[] args) {
		Map<String, Person> personsMap = new HashMap<String, Person>();
		Person p1 = new Person("Igor", 28, 4000);
		Person p2 = new Person("Ivan", 34, 5500);
		Person p3 = new Person("Max", 24, 2400);
		
		personsMap.put(p1.getName(), p1);
		personsMap.put(p2.getName(), p2);
		personsMap.put(p3.getName(), p3);
		
		for(String key : personsMap.keySet()) { //All keys output
			System.out.println(key);
		}
		
		for(Person value : personsMap.values()) { //All values output
			System.out.println(value);
		}
		
		for (Map.Entry entry : personsMap.entrySet()) {
		    System.out.println("Key: {" + entry.getKey() + "} Value: {"
		        + entry.getValue() + "}");
		}
	}

}
