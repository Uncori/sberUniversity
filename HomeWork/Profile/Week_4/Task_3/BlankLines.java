package Task_3;

import java.util.stream.Stream;

public class BlankLines {
    public static void main(String[] args) {
        System.out.println(Stream.of("abc", "", "", "def", "qqq")
                .filter(s -> !s.isEmpty())
                .count());
    }
}
