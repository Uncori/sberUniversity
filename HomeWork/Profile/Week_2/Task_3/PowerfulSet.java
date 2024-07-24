package Task_3;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {
    private PowerfulSet() {
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> res = new HashSet<>(set1);
        res.retainAll(set2);
        return res;
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>(set1);
        set.addAll(set2);
        return set;
    }

    public static <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>(set1);
        set.removeAll(set2);
        return set;
    }
}
