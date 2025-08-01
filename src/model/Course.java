	// Course details (title, ID, capacity, etc.).

//    package model;
//
//    import java.util.ArrayList;
//    import java.util.List;
//
//    public class Course {
//        private int id;
//        private String courseName;
//        private int maxCapacity;
//        private List<Student> enrolledStudents;
//
//        public Course(int id, String courseName, int maxCapacity) {
//            this.id = id;
//            this.courseName = courseName;
//            this.maxCapacity = maxCapacity;
//            this.enrolledStudents = new ArrayList<>();
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public String getCourseName() {
//            return courseName;
//        }
//
//        public int getMaxCapacity() {
//            return maxCapacity;
//        }
//
//        public List<Student> getEnrolledStudents() {
//            return enrolledStudents;
//        }
//
//        public boolean isFull() {
//            return enrolledStudents.size() >= maxCapacity;
//        }
//
//        public void addStudent(Student student) {
//            enrolledStudents.add(student);
//        }
//
//        public void removeStudent(Student student) {
//            enrolledStudents.remove(student);
//        }
//    }
