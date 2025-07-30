// 	Course registration logic: add/drop, validation.
package service;
import model.Student;
import model.Course;
import exception.CourseFullException;

import java.util.List;

public class RegistrationService {

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

            if (student != null && course != null) {
                register(student, course); // reuse existing method
            }
        }

    public void drop(Student student, Course course) {

        student.getRegisteredCourses().remove(course);


        course.getEnrolledStudents().remove(student);

        System.out.println("Student dropped the course successfully.");
    }


}



    

