package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoService {

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
