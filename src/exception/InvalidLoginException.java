// When login fails

//package exception;
//
//public class InvalidLoginException extends Throwable {
//    public InvalidLoginException(String message) {
//        super(message);
//    }
//}

package exception;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String message) {
        super(message);
    }
}

    

