package com.kademika.day7.stack;

public class StackLauncher {

	public static void main(String[] args) {
		Stack st = new Stack();
		
		st.push(42);
		System.out.print("stack: ");
		st.printStack();
		
		st.push(66);
		System.out.print("stack: ");
		st.printStack();
		
		st.push(99);
		System.out.print("stack: ");
		st.printStack();
		
		System.out.println("peak() -> " + st.peak());
		System.out.print("stack: ");
		st.printStack();
		
		System.out.println("pop() -> " + st.pop());
		System.out.print("stack: ");
		st.printStack();
		
	}

}
