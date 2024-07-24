package Task_7;

import java.util.Scanner;

public class EqualsString {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String str = input.next();
//        String str1 = input.next();
//        System.out.println(myEquals(str, str1));
        // test
        System.out.println(myEquals("cat", "cats"));
        System.out.println(myEquals("cat", "cut"));
        System.out.println(myEquals("cat", "nut"));
        System.out.println(myEquals("aas", "ass"));
        System.out.println(myEquals("aas", "saas"));
        System.out.println(myEquals("qwee", "qweeeeer"));
        System.out.println(myEquals("rqwee", "qrqwee"));
    }

    public static boolean myEquals(String str, String str1) {
        if (str.isEmpty() || str1.isEmpty()) {
            return false;
        }
        if (Math.abs(str.length() - str1.length()) > 1) {
            return false;
        }
        long count = str.chars().distinct().count();
        String res = str.concat(str1);
        long ourCount = res.chars().distinct().count();
        return ourCount - count == 1 || ourCount - count == 0;
    }
}
