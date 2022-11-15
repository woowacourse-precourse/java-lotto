package lotto.service;

import static lotto.utils.Constants.LAST_PLACE;
import static lotto.utils.Constants.MINIMUN_REQUIRED_NUMBER_OF_MATCHING_NUMBER;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;
import java.util.List;

public class WinningService {
    public static int[] compareAllLottoWithWinningNumbers(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] rankingCount = new int[LAST_PLACE + 1];

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

        if (isFirstPlace(matchingNumberCount)) {
            return Ranking.FIRST.getPlace();
        }
        if (isSecondPlace(matchingNumberCount, lotto, bonusNumber)) {
            return Ranking.SECOND.getPlace();
        }
        if (isNonePlace(matchingNumberCount)) {
            return Ranking.NONE.getPlace();
        }
        return LAST_PLACE + MINIMUN_REQUIRED_NUMBER_OF_MATCHING_NUMBER - matchingNumberCount;
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

    private static boolean isFirstPlace(int matchingNumberCount) {
        return matchingNumberCount == Ranking.FIRST.getMatchingNumberCount();
    }

    private static boolean isSecondPlace(int matchingNumberCount, Lotto lotto, int bonusNumber) {
        boolean hasFiveMatchingNumber = matchingNumberCount == Ranking.SECOND.getMatchingNumberCount();

        return hasFiveMatchingNumber && hasBonusNumber(lotto, bonusNumber);
    }

    private static boolean isNonePlace(int matchingNumberCount) {
        return matchingNumberCount <= Ranking.NONE.getMatchingNumberCount();
    }
}
