package com.kademika.day7.ownlist;

//import java.util.ArrayList;

public class ArrayListLauncher {

	public static void main(String[] args) {
//		ArrayList<Object> alist = new ArrayList<>();
//		alist.add("First");
//		alist.add("Second");
//		alist.add("Third");
//		alist.set(0, alist.get(2));
//		System.out.println(alist);
		
		SimpleArrayList sal = new SimpleArrayList(4);
		sal.add("first");
		sal.add("second");
		sal.add("third");
		sal.add("fourth");
		sal.add("fifth");
		sal.add("sixth");
		sal.add("seventh");
		sal.add("eighth");
		sal.add("ninth");
		
		sal.printList();
		System.out.println(sal.getSize());
		
		sal.add(4, "5th");
		sal.printList();
		System.out.println(sal.getSize());
		
		sal.remove(5);
		sal.printList();
		System.out.println(sal.getSize());
		
		sal.remove("sixth");
		sal.printList();
		System.out.println(sal.getSize());
		
	}

}
