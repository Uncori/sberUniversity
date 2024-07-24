package Task_2;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(method(s, t));
        // fast test
        System.out.println(method("пила", "липа"));
        System.out.println(method("пила", "липо"));
    }


    public static boolean method(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return false;
        }

        Set<Character> set_s = new TreeSet<>();
        for (char ch : s.toCharArray()) {
            set_s.add(ch);
        }
        Set<Character> set_t = new TreeSet<>();
        for (char ch : t.toCharArray()) {
            set_t.add(ch);
        }
        return set_t.equals(set_s);
    }
}
