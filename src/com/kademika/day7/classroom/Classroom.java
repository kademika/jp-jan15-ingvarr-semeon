package com.kademika.day7.classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private List <Student> students;
	
	public Classroom() {
		students = new ArrayList<>();
	}
	
	public void enter(Student s) {
		students.add(s);
	}
	
	public void leave(Student s) {
		System.out.println(s.toString() + " left the room!");
		students.remove(s);
	}
	
	public int getStudentCount() {
		return students.size();
	}
	
	public boolean isPresent(Student s) {
		return students.contains(s);
		
//		for (int i = 0; i < students.toArray().length; i++) {
//			if (students.get(i).getName() == s.getName() && students.get(i).getSurname() == s.getSurname()) {
//				return true;
//			}
//		}
//		return false;
	}
	
	public void printStudentInfo() { //All students
		for (int i = 0; i < students.toArray().length; i++) {
			System.out.println(students.toArray()[i]);
		}
		//System.out.println(students.toString());
	}

	public List<Student> getStudents() {
		//return students; //Return reference to list
		return new ArrayList<>(students); //A shallow copy of students list (!) As a rule should use this approach
	}
	
}
