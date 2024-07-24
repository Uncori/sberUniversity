package Task_1;

import java.util.stream.IntStream;

public class SumOdd {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 100)
                .filter(x -> x % 2 == 0)
                .sum());
    }
}
