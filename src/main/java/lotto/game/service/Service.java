package lotto.game.service;

import lotto.user.Lotto;
import lotto.util.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service extends Generator {
    private static final int DEFAULT_SCORE = 0;

    public Map<Integer, Integer> calculateDrawScore(List<Lotto> lottos, Lotto draw) {
        Map<Integer, Integer> drawScore = new HashMap<>();

        for (Lotto lotto : lottos) {
            int score = lotto.calculateDraw(draw);
            drawScore.put(score, drawScore.getOrDefault(score, DEFAULT_SCORE) + 1);
        }
        return drawScore;
    }

    public int calculateBonusScore(Map<Integer, Integer> drawScore, List<Lotto> lottos, Lotto draw, int bonus) {
        int bonusScore = 0;

        for (Lotto lotto : lottos) {
            bonusScore += lotto.calculateBonus(draw, bonus);
        }
        if (drawScore.get(Constant.FIVE) != null) {
            drawScore.put(Constant.FIVE, drawScore.get(Constant.FIVE) - bonusScore);
        }
        return bonusScore;
    }

    public double calculateEarningsRate(Map<Integer, Integer> drawScore, int bonusScore, int quantity) {
        int totalPrize = calculateTotalPrize(drawScore, bonusScore);
        return (double) totalPrize / (quantity * Constant.PURCHASE_UNIT);
    }

    private int calculateTotalPrize(Map<Integer, Integer> drawScore, int bonusScore) {
        return drawScore.getOrDefault(Constant.THREE, DEFAULT_SCORE) * Constant.THREE_MATCHES_PRIZE
                + drawScore.getOrDefault(Constant.FOUR, DEFAULT_SCORE) * Constant.FOUR_MATCHES_PRIZE
                + drawScore.getOrDefault(Constant.FIVE, DEFAULT_SCORE) * Constant.FIVE_MATCHES_PRIZE
                + bonusScore * Constant.BONUS_MATCHES_PRIZE
                + drawScore.getOrDefault(Constant.SIX, DEFAULT_SCORE) * Constant.SIX_MATCHES_PRIZE;
    }
}
