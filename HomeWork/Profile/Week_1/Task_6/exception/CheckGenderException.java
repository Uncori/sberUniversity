package Task_6.exception;

public class CheckGenderException extends BaseException {
    public CheckGenderException(String message) {
        super(message);
    }

    public CheckGenderException() {
        super("Пол должен быть указан корректно - Male или Female");
    }
}
