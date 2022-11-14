package lotto.domain;

import java.util.List;

public class Comparison {
    public int countWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) count++;
        }

        return count;
    }

    public int countBonusNumber(Lotto lotto, int bonusNumber) {
        int count = 0;

        if (lotto.contains(bonusNumber)) {
            count++;
        }

        return count;
    }
}
