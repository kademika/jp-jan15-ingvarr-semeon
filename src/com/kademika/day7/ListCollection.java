package com.kademika.day7;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListCollection {
	
	List <Integer> numbersI = new ArrayList <Integer>();
	
    List <String> names = new ArrayList <>(); // <> - diamond operator from Java 7
	
	List <List<Integer>>  numbersL = new ArrayList <>();
	
	List <Double> numbersD = new LinkedList <>();

	public static void main(String[] args) {
		ListCollection listCollection = new ListCollection();

	}
	
}
