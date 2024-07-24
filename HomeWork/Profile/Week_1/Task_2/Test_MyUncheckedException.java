package Task_2;

public class Test_MyUncheckedException {
    public static void main(String[] args) throws MyUncheckedException {
        int[] array = new int[10];
        try {
            for (int i = 0; i < 11; ++i) {
                array[i] = i;
                System.out.println(array[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException -> FOUND!");
            throw new MyUncheckedException("Выход за границу массива!");
        }
    }
}
