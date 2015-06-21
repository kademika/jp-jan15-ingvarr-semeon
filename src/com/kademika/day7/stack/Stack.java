package com.kademika.day7.stack;

//LIFO (Last In First Out)

public class Stack {
	private Node top;
	private int size;
	
	private class Node {
		private Object obj;
		private Node ref;
	}
	
	public Stack() {
		this.size = 0;
	}
	
	public void push(Object obj) {
		Node node = new Node();
		node.obj = obj;
		
		if (top != null) {
			node.ref = top;
		}
		top = node;
		size++;
	}
	
	public Object pop() {
		Object result = top.obj;
		if (top == null) {
			return null;
		} else {
			top = top.ref;
			return result;
		}
	}
	
	public Object peak() {
		if (top == null) {
			return null;
		} else {
			return top.obj;
		}
	}
	
	public void printStack() {
		if (size == 0) {
			System.out.println("Stack is empty");
			return;
		}
		
		Node current = top;
		System.out.print("{");
		while (current.ref != null) {
			System.out.print(current.obj + ", ");
			current = current.ref;		
		}
		System.out.println(current.obj + "}");
	}
}
