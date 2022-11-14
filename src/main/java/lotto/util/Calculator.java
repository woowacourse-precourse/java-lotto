package lotto.util;

public class Calculator {
    
    public static double getRateOfReturn(long amount, long returnAmount) {
        return round(100 + (((double) (returnAmount - amount) / amount) * 100), 1);
    }
    
    private static double round(double number, int n) {
        return Math.round(number * 10 * n) / ((double) 10 * n);
    }
}
