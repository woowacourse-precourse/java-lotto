package lotto.service;

import static lotto.utils.Constants.NUMBER_OF_RANKING;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;
import java.util.List;

public class WinningService {
    public static int[] compareAllLottoWithWinningNumbers(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] rankingCount = new int[NUMBER_OF_RANKING + 1];

        for (Lotto lotto : lottos) {
            int ranking = compareWithWinningNumbers(lotto, winningNumber);
            rankingCount[ranking] += 1;
        }

        return rankingCount;
    }

    private static int compareWithWinningNumbers(Lotto lotto, WinningNumber winningNumber) {
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

    private static int compareWithoutBonusNumber(Lotto lotto, List<Integer> winningNumbers) {
        int matchingNumberCount = 0;
        for (int playerNumber : lotto.getNumbers()) {
            if (winningNumbers.contains(playerNumber)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    private static boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
