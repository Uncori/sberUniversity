package Task_5;

import java.io.IOException;
import java.util.Scanner;

public class CorrectMistake {
    public static void main(String[] args) {
        try {
            inputN();
            System.out.println("Успешный ввод!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputN() throws IOException {
        System.out.println("Введите число n, 0 < n < 100");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n >= 100 || n <= 0) {
                throw new IOException("Неверный ввод");
            }
        }
    }

}
