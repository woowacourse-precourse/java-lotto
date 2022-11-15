package lotto;

public class Statistics {
    private final float yield;

    public Statistics(float yield) {
        this.yield = yield;
    }

    // 수익률 계산 (%)
    public static String calulateYield(int profit, int cost) {
        return String.format("%.1f", (float) profit / cost * 100);
    }
}
