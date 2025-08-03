package model;

public class Course {
    private int id;
    private String name;
    private int capacity;
    private int enrolledCount;

    public Course(int id, String name, int capacity, int enrolledCount) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.enrolledCount = enrolledCount;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEnrolledCount(int enrolledCount) {
        this.enrolledCount = enrolledCount;
    }

    // Helper: Check if course is full
    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Capacity: %d | Enrolled: %d",
            id, name, capacity, enrolledCount
        );
    }
}
