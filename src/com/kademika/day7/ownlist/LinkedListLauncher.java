package com.kademika.day7.ownlist;

import java.util.Iterator;

public class LinkedListLauncher {

	public static void main(String[] args) {
		
		SimpleLinkedList sll = new SimpleLinkedList(); ////
		
		System.err.println("test addFirst, addLast, addAfter methods");
		System.out.println();
		
		sll.addFirst("first");
		sll.addFirst("second");
		sll.addFirst("third");
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		String mark = "mark";
		
		sll.addLast(mark);
		sll.addLast("last");
		sll.addLast("LAST");
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		String middle = "middle";
		
		sll.addAfter(middle, mark);
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		sll.addAfter("middle (-1)", mark);
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		System.out.println();
		System.err.println("test addAfter method, list size == 1");
		System.out.println();
		
		sll = new SimpleLinkedList(); ////
		
		sll.addLast(mark);
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		sll.addAfter("last", mark);
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		System.out.println();
		System.err.println("test addAfter method, no prev element exception");
		System.out.println();
		
		sll = new SimpleLinkedList(); ////
		
		sll.addLast("element");
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		System.out.println();
		
		sll.addAfter("last", mark);
		System.out.print(sll.getSize() + " list elements: ");
		sll.printList();
		
		
//		System.err.println("Test iterator");
//		System.out.println();
//		
//		/*SimpleLinkedList*/ sll = new SimpleLinkedList(); ////
//		
//		sll.addFirst("third");
//		sll.addFirst("second");
//		sll.addFirst("first");
//		
//		for (Object o : sll) {
//			String s = (String) o;
//			System.out.println(s);
//		}
//		
//		System.out.println();
//		System.out.println("The same operations:");
//		System.out.println();
//		
//		for(Iterator<Object> it = sll.iterator(); it.hasNext();) {
//			Object o = it.next();
//			System.out.println(o);
//		}
//		
//		
//		System.out.println();
//		System.err.println("Test remove() method");
//		System.out.println();
//		
//		for(Iterator<Object> it = sll.iterator(); it.hasNext();) {
//			it.next();
//			it.next();
//			it.next();
//			it.remove();
//			break;
//		}
//		System.out.println("One element was removed:");
//		sll.printList();
	
	}

}
