package Task_5;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidBrackets {
    public static void main(String[] args) {
        // task 5
        System.out.println("Task 5: ");
        System.out.println("\t" + validator("(()()())"));
        System.out.println("\t" + validator(")("));
        System.out.println("\t" + validator("(()"));
        System.out.println("\t" + validator("((()))"));
        // task 6
        System.out.println("Task 6: ");
        System.out.println("\t" + validator("{()[]()}"));
        System.out.println("\t" + validator("{)(}"));
        System.out.println("\t" + validator("[}"));
        System.out.println("\t" + validator("[{(){}}][()]{}"));
    }

    private static boolean validator(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (Character c : str.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
