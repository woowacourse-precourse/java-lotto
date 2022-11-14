package lotto.util;

public class Calculator {
    private static final int FIRST_RANK = 2000000000;
    private static final int SECOND_RANK = 30000000;
    private static final int THIRD_RANK = 1500000;
    private static final int FOURTH_RANK = 50000;
    private static final int FIFTH_RANK = 5000;

    public static double rateProfit(int pay, int[] rank) {
        double sum = rank[1] * FIRST_RANK
                + rank[2] * SECOND_RANK
                + rank[3] * THIRD_RANK
                + rank[4] * FOURTH_RANK
                + rank[5] * FIFTH_RANK;
        return sum / pay * 100;
    }
}
