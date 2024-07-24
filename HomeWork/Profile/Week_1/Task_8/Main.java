package Task_8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            if (count < 1) {
                throw new IllegalArgumentException("Число должно быть больше нуля");
            }

            int[] arr = new int[count];
            for (int i = 0; i < count; ++i) {
                arr[i] = scanner.nextInt();
            }

            int target = scanner.nextInt();

            System.out.println(binarySearch(arr, target));

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] > target) {
                right = middle - 1;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                index = middle;
                break;
            }
        }

        return index;
    }

}
