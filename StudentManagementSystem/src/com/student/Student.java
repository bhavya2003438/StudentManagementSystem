
	package com.student;

	public class Student {

	    private int id;
	    private String name;
	    private String email;
	    private String course;
	    private int marks;

	    public Student(String name, String email, String course, int marks) {
	        this.name = name;
	        this.email = email;
	        this.course = course;
	        this.marks = marks;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getCourse() {
	        return course;
	    }

	    public int getMarks() {
	        return marks;
	    }
	}


