package lotto;

public class Calculation {
    public static String profitRate(int cost, int earn) {
        double rate = (double) earn / (double) cost * 100;
        return String.format("%.1f%%", rate);
    }
}