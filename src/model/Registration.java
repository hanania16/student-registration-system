//Represents a student-course pair (can include timestamp).
package model;

public class Registration {
    private int registrationId;
    private int studentId;
    private int courseId;

    public Registration(int registrationId, int studentId, int courseId) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // Getters and Setters
    public int getRegistrationId() { return registrationId; }
    public void setRegistrationId(int registrationId) { this.registrationId = registrationId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
}
