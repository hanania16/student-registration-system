// Thrown when a course has no space.
//package exception;
//
//public class CourseFullException extends Throwable {
//    public CourseFullException(String message) {
//        super(message);
//
//}}
package exception;

public class CourseFullException extends RuntimeException {
    public CourseFullException(String message) {
        super(message);
    }
}
