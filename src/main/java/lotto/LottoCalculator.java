package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoCalculator {
    private List<Integer> rankCount;
    Judgement judgement;

    public LottoCalculator() {
        rankCount = Arrays.asList(0, 0, 0, 0, 0);
        judgement = new Judgement();
    }

    public List<Integer> getRankCount() {
        return rankCount;
    }

    public int compare(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber) {
        int count = judgement.correctCount(lotto, winningNumbers);
        if (count < 5 || !judgement.hasBonusNumbers(bonusNumber, lotto)) {
            count--;
        }
        return count - 2;
    }

    public void addRankCount(int count) {
        if (count < 0) {
            return;
        }
        rankCount.set(count, rankCount.get(count) + 1);
    }

    public double sumOfPrizeMoney() {
        double sum = 0;
        return sum;
    }

}
