package lotto;

import java.util.Map;

public class Calculator {
    public double getLottoCount(double money) {
        return money / 1000.0;
    }

    public Rank calculateRank(int correctCount, boolean bonus) {
        if (correctCount != 5) {
            bonus = false;
        }
        return Rank.findByCorrectCountAndBonus(correctCount, bonus);
    }

    public double calculateYield(Map<Rank, Integer> result, double money) {
        double earnMoney = 0;
        for (Rank rank : result.keySet()) {
            earnMoney += rank.money * result.get(rank);
        }
        return Math.round(earnMoney/money * 100 * 10) / 10.0;
    }
}
