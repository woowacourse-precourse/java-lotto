package lotto.domain.lotto;

import java.util.List;
import lotto.domain.place.MatchResult;
import lotto.domain.place.PlaceCondition;

public class WinningLotto extends LottoWithBonusNum {

    public WinningLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public MatchResult makeMatchResult(PurchaseLotto purchaseLotto) {

        return MatchResult.findByCondition(makeCondition(purchaseLotto));
    }

    private PlaceCondition makeCondition(PurchaseLotto purchaseLotto) {
        return PlaceCondition.findByCondition(purchaseLotto.matchCount(lotto), purchaseLotto.IsBonusMatch(bonusNum));
    }


}