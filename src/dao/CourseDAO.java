package dao;

import model.Course;
import java.util.HashMap;
import java.util.Map;

public class CourseDAO {
    private static Map<String, Course> courseMap = new HashMap<>();

    public boolean save(Course course) {
        if (courseMap.containsKey(course.getCourseId())) {
            return false; // already exists
        }
        courseMap.put(course.getCourseId(), course);
        return true;
    }
}
