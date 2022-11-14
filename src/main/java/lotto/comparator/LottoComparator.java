package lotto.comparator;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.status.BoundaryStatus;
import lotto.status.NumberStatus;
import lotto.status.PointStatus;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {
    private List<Integer> compareResult = new ArrayList<>();
    private Integer luckyCount;
    private boolean hasBonusNumber;

    public List<Integer> compareUserLottoAndWinningLotto(List<Lotto> userLottoGroup, BonusNumber bonusNumber, Lotto winningLotto) {
        initWinningResult();
        for (Lotto userLotto : userLottoGroup) {
            Integer luckyCount = compareEachNumber(userLotto, winningLotto, bonusNumber);
            createResult(luckyCount, compareResult);
        }
        return compareResult;
    }

    private void initWinningResult() {
        for (int i = 0; i < 8; i++) {
            compareResult.add(BoundaryStatus.ZERO.getNumber());
        }
    }

    public Integer compareEachNumber(Lotto userLotto, Lotto winningLotto, BonusNumber BonusNumber) {
        initCount();
        for (Integer userLottoNumber : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(userLottoNumber)) {
                luckyCount++;
                continue;
            }
            if (userLottoNumber == BonusNumber.getBonusNumber()) {
                hasBonusNumber = true;
            }
        }
        return calculateLuckyCount(luckyCount, hasBonusNumber);
    }

    private void initCount() {
        luckyCount = BoundaryStatus.ZERO.getNumber();
        hasBonusNumber = false;
    }

    public void createResult(Integer luckyCount, List<Integer> winningResult) {
        if (luckyCount >= 3) {
            winningResult.set(luckyCount, winningResult.get(luckyCount) + 1);
        }
    }

    public Integer calculateLuckyCount(Integer luckyCount, boolean hasBonusNumber) {
        if (hasBonusNumber == true && luckyCount == NumberStatus.SECOND_OR_THIRD_MATCH_COUNT.getNumber()) {
            return PointStatus.POINT_OF_SECOND.getNumber();
        }
        if (luckyCount == NumberStatus.FIRST_MATCH_COUNT.getNumber()) {
            return PointStatus.POINT_OF_FIRST.getNumber();
        }
        return luckyCount;
    }

}
