package lotto.comparator;

import lotto.Const;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class LottoComparator {

    public static List<Integer> compareUserLottoAndWinningLotto(List<Lotto> userLottoGroup, Integer bonusNumber, Lotto winningLotto) {
        List<Integer> winningResult = Arrays.asList(0, 0, 0, 0, 0);

        for (Lotto userLotto : userLottoGroup) {
            Integer luckyCount = compareEachNumber(userLotto, winningLotto, bonusNumber);
            createWinningResult(winningResult, luckyCount);
        }
        return winningResult;
    }

    private static void initCount() {
        Const.luckyCount = 0;
        Const.hasBonusNumber = false;
    }

    private static void createWinningResult(List<Integer> resultCount, Integer luckyCount) {
        if (luckyCount >= 3) {
            resultCount.set(luckyCount - 3, resultCount.get(luckyCount - 3) + 1);
        }
    }

    public static Integer compareEachNumber(Lotto userLotto, Lotto winningLotto, Integer BonusNumber) {
        initCount();
        for (Integer userLottoNumber : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(userLottoNumber)) {
                Const.luckyCount++;
                continue;
            }
            if (userLottoNumber == BonusNumber) {
                Const.hasBonusNumber = true;
            }
        }
        return calculateLuckyCount(Const.luckyCount, Const.hasBonusNumber);
    }

    public static Integer calculateLuckyCount(Integer luckyCount, boolean hasBonusNumber) {
        if (hasBonusNumber == true && luckyCount == 5) {
            return 7;
        }
        return luckyCount;
    }

}
