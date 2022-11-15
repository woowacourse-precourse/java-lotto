package controller;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private static final int PURCHASE_UNIT = 1000;
    private static final int NOTHING_REWARD = 0;
    private static final String FIRST = "FIRST";
    private static final String SECOND = "SECOND";
    private static final String THIRD = "THIRD";
    private static final String FOURTH = "FOURTH";
    private static final String FIFTH = "FIFTH";
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

    public static int getWinningPrice(String winning){
        if(winning.equals(FIRST)){
            return Winning.FIRST.getReward();
        }
        if(winning.equals(SECOND)){
            return Winning.SECOND.getReward();
        }
        if(winning.equals(THIRD)){
            return Winning.THIRD.getReward();
        }
        if(winning.equals(FOURTH)){
            return Winning.FOURTH.getReward();
        }
        if(winning.equals(FIFTH)){
            return Winning.FIFTH.getReward();
        }
        return NOTHING_REWARD;
    }
}
