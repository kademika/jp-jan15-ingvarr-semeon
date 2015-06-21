package com.kademika.day9.subscription;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof ActionEvent) {
			if (o instanceof Newspaper) {
				System.out.println("--Notification about the new issue of " + ((Newspaper) o).getTitle() + " was recieved--");
			}
			if (o instanceof Magazine) {
				System.out.println("--Notification about the new issue of " + ((Magazine) o).getTitle() + " was recieved--");
			}
		}
	}
	
}
