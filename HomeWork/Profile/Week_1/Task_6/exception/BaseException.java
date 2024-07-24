package Task_6.exception;

public class BaseException extends IllegalArgumentException {
    public BaseException(String message) {
        super(message);
        System.out.println("LOG: " + message);
    }

    public BaseException(String message, Throwable course) {
        super(message, course);
    }
}
