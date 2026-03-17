
	package com.student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.println("7. View Students Sorted by Marks");
            System.out.println("8. Total Students Count");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    Student student = new Student(name, email, course, marks);
                    dao.addStudent(student);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    dao.searchStudent(id);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    
                    int newMarks = sc.nextInt();
        

                    dao.updateStudent(updateId, newName, newEmail, newCourse, newMarks);
                    break;

                case 6:
                    System.out.println("Thank You! Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                case 7:
                    dao.sortByMarks();
                    break;
                case 8:
                    dao.totalStudents();
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }
}
