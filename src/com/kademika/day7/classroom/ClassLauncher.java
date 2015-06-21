package com.kademika.day7.classroom;

public class ClassLauncher {

	public static void main(String[] args) {
		Classroom classroom = new Classroom();
		Student ah = new Student("Alex", "Havaldzhy");
		
		classroom.enter(new Student("Oleg", "Yushchenko"));
		classroom.enter(new Student("Igor", "Semenov"));
		classroom.enter(new Student("Vadim", "Dovbysh"));
		classroom.enter(new Student("Sergey", "Nikolaev"));
		classroom.enter(new Student("Igor", "Demchenko"));
		classroom.enter(ah);
		
		classroom.printStudentInfo();
		System.out.println("Students count: " + classroom.getStudentCount());
		
		System.out.println(ah.toString() + " is present: " + classroom.isPresent(ah));
		
		classroom.leave(ah);
		
		System.out.println();
		classroom.printStudentInfo();
		System.out.println("Students count: " + classroom.getStudentCount());
		
		System.out.println(ah.toString() + " is present: " + classroom.isPresent(ah));
		
//		classroom.enter(ah);
//		
//		System.out.println(ah.toString() + " is present: " + classroom.isPresent(ah));
	}

}
