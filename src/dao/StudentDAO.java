// Add, update, delete, get student.
package dao;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private List<Student> students = new ArrayList<>();

    // Temporary in-memory data (you can replace this with DB logic later)
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Not found
    }

    // Optional: addStudent() to populate mock data
    public void addStudent(Student student) {
        students.add(student);
    }
}
