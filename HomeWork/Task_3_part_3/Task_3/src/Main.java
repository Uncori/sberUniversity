import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int y = input.nextInt();
        int x = input.nextInt();

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();

        for (int i = 0; i < x; ++i) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < y; ++j) {
                list.add(i + j);
            }
            array.add(list);
        }

        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                System.out.print(array.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}