package Task_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            if (count < 2) {
                throw new IllegalArgumentException("Число должно быть положительным и более 2");
            }

            int[] array = new int[count];
            for (int i = 0; i < count; i++) {
                array[i] = scanner.nextInt();
            }

            maxNumber(array);
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage());
        }

    }

    public static void maxNumber(int[] array) {
        int first = array[0];
        int second = array[1];

        if (second > first) {
            int tmp = second;
            second = first;
            first = tmp;
        }

        for (int i = 2; i < array.length; ++i) {
            if (array[i] > first) {
                second = first;
                first = array[i];
            } else if (array[i] > second) {
                second = array[i];
            }
        }

        System.out.println(first + " " + second);
    }

}
