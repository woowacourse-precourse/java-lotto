package lotto;

public class Yield {
    public static double getYield(int payment, int totalPrize) {
        double yield = ((double)totalPrize / (double)payment) * 100;
        return yield;
    }
}
