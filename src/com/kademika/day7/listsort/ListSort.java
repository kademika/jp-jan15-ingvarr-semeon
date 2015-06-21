package com.kademika.day7.listsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {

	public static void main(String[] args) {
		List<String> streets = new ArrayList<>();
		//ArrayList<String> streets2 = new ArrayList<>(); //What is different in syntax?
		//ArrayList streets3 = new ArrayList();
		streets.add("Mykoly Bazhana Ave");
		streets.add("Elyzavety Chavdar St");
		streets.add("Borysa Hmyri St");
		streets.add("Mykhaila Hryshka St");
		streets.add("Oleksandra Myshuhy St");
		streets.add("Petra Grygorenka Ave");
		streets.add("Anny Akhmatovoi St");
		streets.add("Knyazhyi Zaton St");
		streets.add("Urlivska St");
		streets.add("Zdolbunivska St");
		
		Collections.sort(streets); //case sensitive (without compareToIgnoreCase() method)
		
		for(String street : streets) {
			System.out.println(street);
		}
		
//		Collections.sort(streets, new StringZAComparator());
		
		Collections.sort(streets, new Comparator<Object>() { //Anonymous Class
			public int compare(Object o1, Object o2 ) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				int result = s1.compareToIgnoreCase(s2);
				if (result < 0) {
					return 1;
				} else if (result > 0) {
					return -1;
				}
				return 0;
			}
		});
		
		System.out.println();
		for(String street : streets) {
			System.out.println(street);
		}
	}

}
