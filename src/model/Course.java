package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String courseName;
    private int maxCapacity;

    private List<Student> enrolledStudents;

    public Course(int id, String courseName, int maxCapacity) {
        this.id = id;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    // Add/remove students
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void dropStudent(Student student) {
        enrolledStudents.remove(student);
    }
}
