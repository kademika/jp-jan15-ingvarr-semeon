package com.kademika.day9.subscription;

import java.util.Observer;

public class SubscriptionDemo {

	public static void main(String[] args) {
		System.out.println("Subscription system was launched");
		System.out.println();
		
		Newspaper n = new Newspaper("New York Times");
		Magazine m = new Magazine("Forbes");
		
		Observer subscriber1 = new Subscriber();
		Observer subscriber2 = new Subscriber();
		
		n.addObserver(subscriber1);
		System.out.println("{New subscription on " + n.getTitle() + " was performed}");
		
		m.addObserver(subscriber1);
		System.out.println("{New subscription on " + m.getTitle() + " was performed}");
		
		m.addObserver(subscriber2);
		System.out.println("{New subscription on " + m.getTitle() + " was performed}");
		System.out.println();

		n.prepareNewIssue();
		m.prepareNewIssue();
		
		System.out.println();
		
		n.publishNewIssue();
		m.publishNewIssue();
	}

}
