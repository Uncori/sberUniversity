package packet;

public class Atm {
    private double rubbles, dollars;
    private static int count = 0;

    public Atm(double rate, String currency) {
        if (currency.equals("dollar")) {
            this.dollars = rate;
        } else if (currency.equals("ruble")) {
            this.rubbles = rate;
        } else {
            this.rubbles = 0;
            this.dollars = 0;
        }
        ++count;
    }

    public static int getCount() {
        return count;
    }

    public double transferDollar(double rubbles) {
        double res = rubbles * this.dollars;
        return Math.round(res * 1000.0) / 1000.0;
    }

    public double transferRubbles(double dollars) {
        double res = dollars * this.rubbles;
        return Math.round(res * 1000.0) / 1000.0;
    }

}
