package Task_6.exception;

public class CheckHeightException extends BaseException {
    public CheckHeightException(String message) {
        super(message);
    }

    public CheckHeightException() {
        super("рост должен быть положительным числом и корректно конвертироваться в double");
    }

    public CheckHeightException (String message, Throwable course) {
        super(message, course);
    }
}
