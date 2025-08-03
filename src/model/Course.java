package model;

public class Course {
    private int id;
    private String name;
    private int capacity;
    private int enrolled;

    public Course(int id, String name, int capacity, int enrolled) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.enrolled = enrolled;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public int getEnrolled() { return enrolled; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setEnrolled(int enrolled) { this.enrolled = enrolled; }

    // Helper
    public boolean isFull() {
        return enrolled >= capacity;
    }
}
