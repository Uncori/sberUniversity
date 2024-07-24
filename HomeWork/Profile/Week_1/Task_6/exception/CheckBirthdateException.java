package Task_6.exception;

public class CheckBirthdateException extends BaseException {
    public CheckBirthdateException(String message) {
        super(message);
    }

    public CheckBirthdateException() {
        super("Дата рождения должна быть не раньше 01.01.1900 и не позже текущей даты");
    }
}
