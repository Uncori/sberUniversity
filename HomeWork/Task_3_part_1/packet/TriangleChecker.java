package packet;

public class TriangleChecker {

    public static boolean checkTriangle(double a, double b, double c) {
        a = Math.round(a * 100.0) / 100.0;
        b = Math.round(b * 100.0) / 100.0;
        c = Math.round(c * 100.0) / 100.0;
        return a + b >= c && b + c >= a && a + c >= b;
    }

}
