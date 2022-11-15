package lotto.game;

import lotto.user.Lotto;
import lotto.user.Quantity;
import lotto.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private static final int DEFAULT_SCORE = 0;
    private static final int PURCHASE_UNIT = 1_000;

    public int generateQuantity(String purchaseAmount) {
        return Quantity
                .generate(purchaseAmount)
                .calculateQuantity();
    }

    public List<Lotto> generateLottos(int quantity) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < quantity) {
            lottoNumbers.add(Lotto.generate());
        }
        return lottoNumbers;
    }

    public Lotto generateDraw(String numbers) {
        return Lotto.generate(numbers);
    }

    public int generateBonus(String number) {
        return Integer.parseInt(number);
    }

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
        if (drawScore.get(Constant.FOUR) != null) {
            drawScore.put(Constant.FOUR, drawScore.get(Constant.FOUR) - bonusScore);
        }
        return bonusScore;
    }

    public double calculateEarningsRate(Map<Integer, Integer> drawScore, int bonusScore, int quantity) {
        int totalPrize = calculateTotalPrize(drawScore, bonusScore);
        return (double) totalPrize / (quantity * PURCHASE_UNIT);
    }

    private int calculateTotalPrize(Map<Integer, Integer> drawScore, int bonusScore) {
        return drawScore.getOrDefault(Constant.THREE, DEFAULT_SCORE) * Constant.THREE_MATCHES_PRIZE
                + drawScore.getOrDefault(Constant.FOUR, DEFAULT_SCORE) * Constant.FOUR_MATCHES_PRIZE
                + drawScore.getOrDefault(Constant.FIVE, DEFAULT_SCORE) * Constant.FIVE_MATCHES_PRIZE
                + bonusScore * Constant.BONUS_MATCHES_PRIZE
                + drawScore.getOrDefault(Constant.SIX, DEFAULT_SCORE) * Constant.SIX_MATCHES_PRIZE;
    }
}
