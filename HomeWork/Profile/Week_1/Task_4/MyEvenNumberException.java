package Task_4;

public class MyEvenNumberException extends Exception {
    public MyEvenNumberException() {
        super("Создание экземпляра класса MyEvenNumber с нечетным числом невозможно");
    }
}

