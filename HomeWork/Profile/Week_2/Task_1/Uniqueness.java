package Task_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Uniqueness {
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("ASD");
        test.add("QWE");
        test.add("ASD");
        test.add("asd");
        test.add("Zxc");
        test.add("qwe");
        test.add("ZXC");
        test.add("zxc");
        test.add("ZXC");
        Set<String> res = method(test);
        System.out.println(res);

        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(3);
        test1.add(4);
        test1.add(5);
        test1.add(1);
        test1.add(10);
        test1.add(2);
        Set<Integer> res1 = method(test1);
        System.out.println(res1);

    }

    public static <T> Set<T> method(ArrayList<T> list) {
        return new HashSet<>(list);
    }
}
