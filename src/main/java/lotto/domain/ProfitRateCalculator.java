package lotto.domain;

import lotto.constant.Score;

import java.util.Map;

import static lotto.constant.Score.*;

public class ProfitRateCalculator {

    private static final int FIVE_THOUSAND = 5000;
    private static final int FIFTY_THOUSAND = 50000;
    private static final int ONE_POINT_FIVE_MILLION = 1500000;
    private static final int THIRTY_MILLION = 30000000;
    private static final int TWO_BILLION = 2000000000;

    public static String getProfitRate(Map<Score, Integer> scoreStore, int money) {
        Integer three = scoreStore.get(THREE);
        Integer four = scoreStore.get(FOUR);
        Integer five = scoreStore.get(FIVE);
        Integer fiveBonus = scoreStore.get(FIVE_BONUS);
        Integer six = scoreStore.get(SIX);

        double totalMoney = getTotalMoney(three, four, five, fiveBonus, six);
        double profitRate = calculateProfitRate(money, totalMoney);

        return String.format("%.1f", profitRate);
    }

    private static double calculateProfitRate(int money, double totalMoney) {
        return (totalMoney / money) * 100;
    }

    private static double getTotalMoney(Integer three, Integer four, Integer five, Integer fiveBonus, Integer six) {
        return (three * FIVE_THOUSAND) + (four * FIFTY_THOUSAND) + (five * ONE_POINT_FIVE_MILLION)
                + (fiveBonus * THIRTY_MILLION) + (six * TWO_BILLION);
    }
}
