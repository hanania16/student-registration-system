package model;

public class Course {
<<<<<<< HEAD
    private int id;
    private String courseName;
    private int maxCapacity;
    private int departmentId;
    private int enrolledCount;

    public Course(int id, String courseName, int maxCapacity, int departmentId) {
        this.id = id;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.departmentId = departmentId;
    }

    public Course(int id, String courseName, int maxCapacity, int departmentId, int enrolledCount) {
        this(id, courseName, maxCapacity, departmentId);
        this.enrolledCount = enrolledCount;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getDepartmentId() { return departmentId; }
    public int getEnrolledStudentsCount() { return enrolledCount; }
=======
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
>>>>>>> f4fd8323e3e006535a6130b71e69a8ecb64df773
}
