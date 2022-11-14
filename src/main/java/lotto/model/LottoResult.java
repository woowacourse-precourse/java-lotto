package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.constants.WinningScore;

public class LottoResult {

    private Map<WinningScore, Integer> winningScoreResult;
    private int bonusNumber;

    public LottoResult(int bonusNumber) {
        this.winningScoreResult = new HashMap<>() {{
            put(WinningScore.THREE, 0);
            put(WinningScore.FOUR, 0);
            put(WinningScore.FIVE, 0);
            put(WinningScore.BONUS, 0);
            put(WinningScore.SIX, 0);
        }};
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningScore, Integer> getWinningScoreResult() {
        return this.winningScoreResult;
    }

    public double computeRateOfReturn(int purchaseAmount) {
        double totalAmount = 0;

        for (Map.Entry<WinningScore, Integer> score : winningScoreResult.entrySet()) {
            int count = score.getValue();
            totalAmount += score.getKey().getMoney() * count;
        }

        return totalAmount / purchaseAmount * 100;
    }

    public void computeWinningScore(Lotto userLotto, Lotto winningLotto) {
        WinningScore winningScore = compareNumber(userLotto.getNumbers(), winningLotto.getNumbers());
        if (winningScore == WinningScore.NONE) {
            return;
        }
        if (isBonusScore(winningScore, userLotto.getNumbers())) {
            winningScoreResult.put(WinningScore.BONUS, winningScoreResult.get(WinningScore.BONUS) + 1);
            return;
        }
        winningScoreResult.put(winningScore, winningScoreResult.getOrDefault(winningScore, 0) + 1);
    }

    public WinningScore compareNumber(List<Integer> userNumber, List<Integer> winningNumber) {
        int count = (int) userNumber.stream().filter(num -> winningNumber.contains(num)).count();
        if (count < 3) {
            return WinningScore.NONE;
        }
        return WinningScore.getScore(count);
    }

    public boolean isBonusScore(WinningScore winningScore, List<Integer> userNumber) {
        return winningScore == WinningScore.FIVE && userNumber.contains(bonusNumber);
    }
}
