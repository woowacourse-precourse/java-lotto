package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoService {
    private static final int NUMBER_OF_RANKING = Ranking.values().length;

    public int compareWithWinningNumbers(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int bonusNumber = winningNumber.getBonusNumber();

        int matchingNumberCount = compareWithoutBonusNumber(lotto, winningNumbers);

        if (matchingNumberCount == Ranking.FIRST.getMatchingNumberCount()) {
            return Ranking.FIRST.getPlace();
        }
        if (matchingNumberCount == Ranking.SECOND.getMatchingNumberCount() && hasBonusNumber(lotto, bonusNumber)) {
            return Ranking.SECOND.getPlace();
        }
        return NUMBER_OF_RANKING + 3 - matchingNumberCount;
    }

    public int compareWithoutBonusNumber(Lotto lotto, List<Integer> winningNumbers) {
        int matchingNumberCount = 0;
        for (int playerNumber : lotto.getNumbers()) {
            if (winningNumbers.contains(playerNumber)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
