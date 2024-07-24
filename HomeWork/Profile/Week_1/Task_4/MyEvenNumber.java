package Task_4;

public class MyEvenNumber {
    public int number;

    public MyEvenNumber(int number) {
        try {
            if (number % 2 != 0) {
                throw new MyEvenNumberException();
            }
            this.number = number;
        } catch (MyEvenNumberException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

