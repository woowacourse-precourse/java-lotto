package lotto.comparator;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.status.BoundaryStatus;
import lotto.status.NumberStatus;
import lotto.status.PointStatus;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {
    private static List<Integer> compareResult = new ArrayList<>();
    private static Integer luckyCount;
    private static boolean hasBonusNumber;

    public static List<Integer> compareUserLottoAndWinningLotto(List<Lotto> userLottoGroup, BonusNumber bonusNumber, Lotto winningLotto) {
        initWinningResult();
        for (Lotto userLotto : userLottoGroup) {
            Integer luckyCount = compareEachNumber(userLotto, winningLotto, bonusNumber);
            createResult(luckyCount, compareResult);
        }
        return compareResult;
    }

    private static void initWinningResult() {
        for (int i = BoundaryStatus.START_NUMBER.getNumber(); i < BoundaryStatus.WINNING_RESULT_LENGTH.getNumber(); i++) {
            compareResult.add(NumberStatus.ZERO.getNumber());
        }
    }

    public static Integer compareEachNumber(Lotto userLotto, Lotto winningLotto, BonusNumber bonusNumber) {
        initCount();
        for (Integer userLottoNumber : userLotto.getNumbers()) {
            checkCorrectNumber(winningLotto, userLottoNumber,bonusNumber);
        }
        return calculateLuckyCount(luckyCount, hasBonusNumber);
    }

    private static void checkCorrectNumber(Lotto winningLotto, Integer userLottoNumber,BonusNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(userLottoNumber)) {
            luckyCount++;
            return;
        }
        if (userLottoNumber == bonusNumber.getBonusNumber()) {
            hasBonusNumber = true;
        }
    }

    private static void initCount() {
        luckyCount = NumberStatus.ZERO.getNumber();
        hasBonusNumber = false;
    }

    public static void createResult(Integer luckyCount, List<Integer> winningResult) {
        if (luckyCount >= NumberStatus.MIN_LUCKY_POINT.getNumber()) {
            winningResult.set(luckyCount, winningResult.get(luckyCount) + NumberStatus.ONE_POINT.getNumber());
        }
    }

    public static Integer calculateLuckyCount(Integer luckyCount, boolean hasBonusNumber) {
        if (hasBonusNumber == true && luckyCount == NumberStatus.SECOND_OR_THIRD_MATCH_COUNT.getNumber()) {
            return PointStatus.POINT_OF_SECOND.getNumber();
        }
        if (luckyCount == NumberStatus.FIRST_MATCH_COUNT.getNumber()) {
            return PointStatus.POINT_OF_FIRST.getNumber();
        }
        return luckyCount;
    }

}
