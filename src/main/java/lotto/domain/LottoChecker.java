package lotto.domain;

import lotto.Model.Lotto;
import lotto.Model.WinningLotto;

import java.util.List;

public class LottoChecker {
    public int lottoCompare(Lotto userLotto, WinningLotto winningLotto) {
        List<Integer> lotto = userLotto.getNumbers();
        Lotto winningNumbers = winningLotto.getWinningNumbers();
        int sameCount = 0;

        for (Integer number : lotto) {
            if (winningNumbers.getNumbers().contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    public boolean bonusCompare(Lotto userLotto, WinningLotto winningLotto) {
        return userLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public double profitRate(int principal, int profit) {
        return Math.round((double) profit / (double) principal * 1000) / 10.0;
    }
}
