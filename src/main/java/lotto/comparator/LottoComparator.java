package lotto.comparator;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class LottoComparator {
    public static Integer luckyCount;
    public static boolean hasBonusNumber;

    public static List<Integer> compareUserLottoAndWinningLotto(List<Lotto> userLottoGroup, Integer bonusNumber, Lotto winningLotto) {
        List<Integer> winningResult = Arrays.asList(0, 0, 0, 0, 0);

        for (Lotto userLotto : userLottoGroup) {
            initCount();
            Integer luckyCount = compareEachNumber(userLotto, winningLotto, bonusNumber);
            createWinningResult(winningResult, luckyCount);
        }
        return winningResult;
    }

    private static void initCount() {
        luckyCount = 0;
        hasBonusNumber = false;
    }

    private static void createWinningResult(List<Integer> resultCount, Integer luckyCount) {
        if (luckyCount >= 3) {
            resultCount.set(luckyCount - 3, resultCount.get(luckyCount - 3) + 1);
        }
    }

    private static Integer compareEachNumber(Lotto userLotto, Lotto winningLotto, Integer BonusNumber) {
        for (Integer userLottoNumber : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(userLottoNumber)) {
                luckyCount++;
                continue;
            }
            if (userLottoNumber == BonusNumber) {
                hasBonusNumber = true;
            }
        }
        return calculateLuckyCount(luckyCount, hasBonusNumber);
    }

    private static Integer calculateLuckyCount(Integer luckyCount, boolean hasBonusNumber) {
        if (hasBonusNumber == true && luckyCount == 5) {
            return 7;
        }
        return luckyCount;
    }

}
