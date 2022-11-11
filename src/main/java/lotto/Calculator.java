package lotto;

import java.util.Map;

public class Calculator {
    public int getLottoCount(double money) {
        return (int)money / 1000;
    }

    public Rank calculateRank(int correctCount, boolean bonus) {
        if (correctCount != 5) {
            bonus = false;
        }
        return Rank.findByCorrectCountAndBonus(correctCount, bonus);
    }

    public double calculateYield(Map<Rank, Integer> result, double money) {
        if (result.size() == 0) {
           return 0;
        }
        double earnMoney = 0;
        for (Rank rank : result.keySet()) {
            earnMoney += rank.money * result.get(rank);
        }
        return Math.round(earnMoney/money * 100 * 10) / 10.0;
    }
}
