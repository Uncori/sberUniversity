package Task_3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        set2.add(4);
        System.out.println("set2 = " + set1);
        System.out.println("intersection : " + PowerfulSet.intersection(set1, set2));
        System.out.println("union : " + PowerfulSet.union(set1, set2));
        System.out.println("relativeComplement : " + PowerfulSet.relativeComplement(set1, set2));
    }
}
