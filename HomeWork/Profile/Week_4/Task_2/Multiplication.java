package Task_2;

import java.util.stream.Stream;

public class Multiplication {
    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .reduce((x, y) -> x * y)
                .get());
    }
}
