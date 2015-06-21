package com.kademika.day9.subscription;

import java.util.Observable;

public class Magazine extends Observable {
	private String title;
	
	public Magazine(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void prepareNewIssue() {
		System.out.println("[The new issue of " + this.getTitle() + " was prepared for publication]");
		setChanged();
		notifyObservers();
	}
	
	public void publishNewIssue() {
		System.out.println("[The new issue of " + this.getTitle() + " was published]");
		setChanged();
		notifyObservers(new ActionEvent("publication"));
	}
	
}
