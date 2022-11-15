package lotto;

import java.util.List;

public class Judgement {
    public int correctCount(List<Integer> lotto, List<Integer> winningNumber) {
        int count = 0;
        for (Integer number : lotto) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBonusNumbers(int bonusNumber, List<Integer> lotto) {
        return lotto.contains(bonusNumber);
    }
}
