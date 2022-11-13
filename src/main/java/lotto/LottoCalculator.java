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
        if (count < 5 || judgement.hasBonusNumbers(bonusNumber, winningNumbers)) {
            count--;
        }
        return count - 2;
    }

}
