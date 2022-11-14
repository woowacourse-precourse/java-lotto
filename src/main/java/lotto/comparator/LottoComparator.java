package lotto.comparator;

import lotto.Const;
import lotto.Lotto;
import lotto.result.LottoResult;

import java.util.List;

public class LottoComparator {

    public static List<Integer> compareUserLottoAndWinningLotto(List<Lotto> userLottoGroup, Integer bonusNumber, Lotto winningLotto) {
        LottoResult l = new LottoResult();
        List<Integer> winningResult = l.getWinningResult();
        for (Lotto userLotto : userLottoGroup) {
            Integer luckyCount = compareEachNumber(userLotto, winningLotto, bonusNumber);
            l.createResult(luckyCount);
        }
        return winningResult;
    }

    private static void initCount() {
        Const.luckyCount = 0;
        Const.hasBonusNumber = false;
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
            return 6;
        }
        if(luckyCount == 6){
            return 7;
        }
        return luckyCount;
    }

}
