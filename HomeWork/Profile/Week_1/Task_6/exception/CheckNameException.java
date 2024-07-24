package Task_6.exception;

public class CheckNameException extends BaseException {
    public CheckNameException(String message) {
        super(message);
    }

    public CheckNameException() {
        super("Длина имени должна быть от 2 до 20 латинских символов, первая буква заглавная");
    }
}
