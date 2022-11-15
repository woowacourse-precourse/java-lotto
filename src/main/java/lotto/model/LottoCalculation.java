package lotto.model;

import java.util.List;
import java.util.Map;

public class LottoCalculation {
    private StatisticsResult result;
    private WinningLotto winningLotto;

    public LottoCalculation(WinningLotto winningLotto) {
        result = new StatisticsResult();
        this.winningLotto = winningLotto;
    }

    public StatisticsResult getStatisticsResult() {
        return result;
    }

    public double computeRateOfReturn(int purchaseAmount) {
        double totalAmount = 0;

        for (Map.Entry<WinningScore, Integer> score : result.getWinningScoreResult().entrySet()) {
            int count = score.getValue();
            totalAmount += score.getKey().getMoney() * count;
        }

        return totalAmount / purchaseAmount * 100;
    }

    public void computeWinningScore(Lotto userLotto) {
        WinningScore winningScore = compareNumber(userLotto.getNumbers());
        if (winningScore == WinningScore.NONE) {
            return;
        }
        if (isBonusScore(winningScore, userLotto.getNumbers())) {
            result.addScoreCount(WinningScore.BONUS, result.getScoreCount(WinningScore.BONUS) + 1);
            return;
        }
        result.addScoreCount(winningScore, result.getScoreCount(winningScore) + 1);
    }

    public WinningScore compareNumber(List<Integer> userNumber) {
        int count = countSameNumber(userNumber, winningLotto.getWinningLotto().getNumbers());
        if (count < WinningScore.THREE.getScore()) {
            return WinningScore.NONE;
        }
        return WinningScore.getScore(count);
    }

    public int countSameNumber(List<Integer> userNumber, List<Integer> winningNumber) {
        return (int) userNumber.stream().filter(num -> winningNumber.contains(num)).count();
    }

    public boolean isBonusScore(WinningScore winningScore, List<Integer> userNumber) {
        return winningScore == WinningScore.FIVE && userNumber.contains(winningLotto.getBonusNumber());
    }
}
