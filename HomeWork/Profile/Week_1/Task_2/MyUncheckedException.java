package Task_2;

public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String errorMessage) {
        super(errorMessage);
        System.out.println(errorMessage);
    }

    public MyUncheckedException(Throwable throwable) {
        super(throwable);
    }
}
