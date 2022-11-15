package controller;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private static final int PURCHASE_UNIT = 1000;
    private static final String NO_WINNING = "NOTHING";

    public static int calculatePurchaseQuantity(int money) throws IllegalArgumentException {
        if (money % PURCHASE_UNIT == 0) {
            return money / PURCHASE_UNIT;
        }
        throw new IllegalArgumentException("[ERROR] 구입금액이 1000원 단위가 아닙니다.");
    }

    public static String calculateYield(int money, int winnings) {
        double yield = ((double) winnings / money) * 100;
        return String.format("%.1f", yield).concat("%");
    }

    public static String calculateWinning(List<Integer> winningCount) {
        for (Winning winning : Winning.values()) {
            List<List<Integer>> comparisonTarget = winning.getWinningCount();
            if (comparisonTarget.contains(winningCount)) {
                return winning.name();
            }
        }
        return NO_WINNING;
    }
}
