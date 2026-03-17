
	package com.student;

	import java.sql.Connection;
import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class StudentDAO {

	    // Add Student
	    public void addStudent(Student student) {
	    	
	    	String grade;

	    	if (student.getMarks() >= 90)
	    	    grade = "A";
	    	else if (student.getMarks() >= 75)
	    	    grade = "B";
	    	else if (student.getMarks() >= 50)
	    	    grade = "C";
	    	else
	    	    grade = "Fail";


	        
	        String sql = "INSERT INTO students(name, email, course, marks, grade) VALUES (?, ?, ?, ?, ?)";


	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, student.getName());
	            ps.setString(2, student.getEmail());
	            ps.setString(3, student.getCourse());
	            ps.setInt(4, student.getMarks());
	            ps.setString(5, grade);


	            ps.executeUpdate();

	            System.out.println("Student Added Successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // View Students
	    public void viewStudents() {

	        String sql = "SELECT * FROM students";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {

	            	System.out.println(
	            	        rs.getInt("id") + " | " +
	            	        rs.getString("name") + " | " +
	            	        rs.getString("email") + " | " +
	            	        rs.getString("course") + " | " +
	            	        rs.getInt("marks") + " | " +
	            	        rs.getString("grade")
	            	);

	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 // Search Student by ID
	    public void searchStudent(int id) {

	        String sql = "SELECT * FROM students WHERE id=?";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	            	System.out.println(
	            	        rs.getInt("id") + " | " +
	            	        rs.getString("name") + " | " +
	            	        rs.getString("email") + " | " +
	            	        rs.getString("course") + " | " +
	            	        rs.getInt("marks") + " | " +
	            	        rs.getString("grade")
	            	);

	                
	            } else {
	                System.out.println("Student Not Found!");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 // Delete Student by ID
	    public void deleteStudent(int id) {

	        String sql = "DELETE FROM students WHERE id=?";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Student Deleted Successfully!");
	            } else {
	                System.out.println("Student Not Found!");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
	    public void updateStudent(int id, String name, String email, String course, int marks) {

	        String sql = "UPDATE students SET name=?, email=?, course=?, marks=? WHERE id=?";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, course);
	            ps.setInt(4, marks);
	            ps.setInt(5, id);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Student Updated Successfully!");
	            } else {
	                System.out.println("Student Not Found!");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void sortByMarks() {

	        String sql = "SELECT * FROM students ORDER BY marks DESC";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                System.out.println(
	                        rs.getInt("id") + " | " +
	                        rs.getString("name") + " | " +
	                        rs.getString("email") + " | " +
	                        rs.getString("course") + " | " +
	                        rs.getInt("marks") + " | " +
	                        rs.getString("grade")
	                );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void totalStudents() {

	        String sql = "SELECT COUNT(*) FROM students";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            if (rs.next()) {
	                System.out.println("Total Students: " + rs.getInt(1));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	}


