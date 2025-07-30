// 	Course registration logic: add/drop, validation.
package service;
import dao.CourseDAO;
import dao.StudentDAO;
import model.Student;
import model.Course;
import exception.CourseFullException;

import java.util.List;





public class RegistrationService {
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    // Constructor
    public RegistrationService(StudentDAO studentDAO, CourseDAO courseDAO) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
    }


    public void register(Student student, Course course) throws CourseFullException {
            List<Student> enrolledStudents = (List<Student>) course.getEnrolledStudents();
            if (enrolledStudents.size() >= course.getMaxCapacity()) {
                throw new CourseFullException("Course is full: " + course.getCourseName());
            }

            if (enrolledStudents.contains(student)) {
                System.out.println("Student already enrolled in this course.");
                return;
            }

            enrolledStudents.add(student);
            student.getRegisteredCourses().add(course);

            System.out.println("Student registered successfully.");



        }
        void drop(Student student ,Course course) {
            if (student == null || course == null) {
                System.out.println("Student or course is null. Cannot drop.");
                return;
            }

            List<Course> registeredCourses = student.getRegisteredCourses();
            List<Student> enrolledStudents = course.getEnrolledStudents();

            if (!registeredCourses.contains(course)) {
                System.out.println("Student is not registered in this course.");
                return;
            }

            registeredCourses.remove(course);
            enrolledStudents.remove(student);

            System.out.println("Student dropped the course successfully.");
        }

    public void register(int studentId, int courseId) throws CourseFullException {

        Student student = studentDAO.findById(studentId);
        Course course = courseDAO.findById(courseId);

        if (student != null && course != null) {
            register(student, course);
        } else {
            System.out.println("Student or course not found.");
        }
    }


}











