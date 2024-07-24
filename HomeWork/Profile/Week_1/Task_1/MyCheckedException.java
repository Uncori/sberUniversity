package Task_1;

public class MyCheckedException extends Exception {
    public MyCheckedException(String errorMessage) {
        super(errorMessage);
        System.out.println(errorMessage);
    }
    public MyCheckedException(Throwable throwable) {
        super(throwable);
    }
}


