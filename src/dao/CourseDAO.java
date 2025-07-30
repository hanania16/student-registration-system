	// CRUD operations for courses.
    package dao;

    import model.Course;
    import java.util.ArrayList;
    import java.util.List;

    public class CourseDAO {
        private List<Course> courses = new ArrayList<>();

        public Course findById(int id) {
            for (Course course : courses) {
                if (course.getId() == id) {
                    return course;
                }
            }
            return null;
        }

        public void addCourse(Course course) {
            courses.add(course);
        }
    }
