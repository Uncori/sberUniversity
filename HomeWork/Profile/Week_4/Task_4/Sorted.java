package Task_4;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Sorted {
    public static void main(String[] args) {
        System.out.println(new Random().doubles(25, 1, 98)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
    }
}
