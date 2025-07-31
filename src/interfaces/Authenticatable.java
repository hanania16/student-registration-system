// 	Interface with method like registerCourse(Course c)
package interfaces;

import exception.InvalidLoginException;

public interface Authenticatable {
    boolean login(String username, String password) throws InvalidLoginException;
};


