package Task_6;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.Collection;

public class Sets {
    public static void main(String[] args) {
        Set<Set<Integer>> sets = Set.of(Set.of(5, 2, 9)
                , Set.of(4, 5, 6)
                , Set.of(7, 8, 9, 10)
                , Set.of(7, 85, 98, 10));

        Set<Object> set = sets.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        System.out.println(set);

    }
}
