package lotto.model;

import java.util.List;

public class LottoCalculation {
    private StatisticsResult result;
    private Lotto winningLotto;
    private Bonus bonus;

    public LottoCalculation(Lotto lotto, Bonus bonus) {
        result = new StatisticsResult();
        this.winningLotto = lotto;
        this.bonus = bonus;
    }

    public StatisticsResult getStatisticsResult() {
        return result;
    }

    public double computeRateOfReturn(int purchaseAmount) {
        double totalAmount = 0;
        for (WinningScore score : result.getAllScore()) {
            totalAmount += score.getMoney() * result.getCount(score);
        }
        return totalAmount / purchaseAmount * 100;
    }

    public void computeWinningResult(Lotto userLotto) {
        int count = countSameNumber(userLotto.getNumbers());
        if (!isWinning(count)) {
            return;
        }
        computeWinningScore(count, userLotto.getNumbers());
    }

    public int countSameNumber(List<Integer> userNumber) {
        return (int) userNumber.stream().filter(num -> winningLotto.getNumbers().contains(num)).count();
    }

    public boolean isWinning(int count) {
        return count >= WinningScore.THREE.getScore();
    }

    public void computeWinningScore(int count, List<Integer> userNumber) {
        WinningScore winningScore = WinningScore.getScore(count);
        if (isBonusScore(winningScore, userNumber)) {
            result.addScoreCount(WinningScore.BONUS, result.getCount(WinningScore.BONUS) + 1);
            return;
        }
        result.addScoreCount(winningScore, result.getCount(winningScore) + 1);
    }

    public boolean isBonusScore(WinningScore winningScore, List<Integer> userNumber) {
        return winningScore == WinningScore.FIVE && userNumber.contains(bonus.getNumber());
    }
}
