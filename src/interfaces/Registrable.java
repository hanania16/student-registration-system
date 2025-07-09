// 	Interface for login methods (e.g., boolean login())
package interfaces;


import Abstract.User;
import exception.CourseFullException;
import model.Course;

public interface Registrable {
    public void register(User user, Course course) throws CourseFullException;
    void drop(User user, Course course);

}




