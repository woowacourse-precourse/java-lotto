package lotto.comparator;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.status.BoundaryStatus;
import lotto.status.NumberStatus;
import lotto.status.PointStatus;

import java.util.List;

public class LottoComparator {
    public static Integer luckyCount;
    public static boolean hasBonusNumber;

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
        luckyCount = BoundaryStatus.ZERO.getNumber();
        hasBonusNumber = false;
    }


    public static Integer compareEachNumber(Lotto userLotto, Lotto winningLotto, Integer BonusNumber) {
        initCount();
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

    public static Integer calculateLuckyCount(Integer luckyCount, boolean hasBonusNumber) {
        if (hasBonusNumber == true && luckyCount == NumberStatus.SECOND_OR_THIRD_MATCH_COUNT.getNumber()) {
            return PointStatus.POINT_OF_SECOND.getNumber();
        }
        if(luckyCount == NumberStatus.FIRST_MATCH_COUNT.getNumber()){
            return PointStatus.POINT_OF_FIRST.getNumber();
        }
        return luckyCount;
    }

}
