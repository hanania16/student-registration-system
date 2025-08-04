package model;

import java.time.LocalDate;

public class Registration {
    private int id;             // Registration ID (primary key in DB)
    private int studentId;
    private String student_name;
    private String student_pass;
    private String depart;
    private int courseId;       // ID of the course
    private LocalDate date;     // When they registered

    public Registration(int id, int studentId, int courseId, LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", date=" + date +
                '}';
    }
}
