package lotto.game;

import lotto.domain.Lotto;
import lotto.domain.Purchase;
import lotto.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.Constant.DEFAULT_SCORE;

public class Service {
    private int quantity;
    private List<Lotto> lottos;
    private Lotto draw;
    private int bonus;
    private Map<Integer, Integer> drawScore;
    private int bonusScore;

    public Service() {
    }

    public int generateQuantity(String purchaseAmount) {
        quantity = Purchase
                .generate(purchaseAmount)
                .calculateQuantity();
        return quantity;
    }

    public List<Lotto> generateLottos() {
        lottos = new ArrayList<>();

        while (lottos.size() < quantity) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    public void generateDraw(String numbers) {
        draw = Lotto.generate(numbers);
    }

    public void generateBonus(String number) {
        bonus = Integer.parseInt(number);
    }

    public Map<Integer, Integer> calculateDrawScore() {
        drawScore = new HashMap<>();

        for (Lotto lotto : lottos) {
            int score = lotto.calculateDraw(draw);
            drawScore.put(score, drawScore.getOrDefault(score, DEFAULT_SCORE) + 1);
        }
        return drawScore;
    }

    public int calculateBonusScore() {
        for (Lotto lotto : lottos) {
            bonusScore += lotto.calculateBonus(draw, bonus);
        }
        if (drawScore.get(Constant.FIVE) != null) {
            drawScore.put(Constant.FIVE, drawScore.get(Constant.FIVE) - bonusScore);
        }
        return bonusScore;
    }

    public double calculateEarningsRate() {
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
