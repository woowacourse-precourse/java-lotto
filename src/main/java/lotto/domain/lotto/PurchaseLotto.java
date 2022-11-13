package lotto.domain.lotto;

import java.util.List;

public class PurchaseLotto extends LottoWithBonusNum {

    public PurchaseLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public PurchaseLotto() {
        super();
    }

    public int matchCount(Lotto otherLotto) {
        return lotto.matchCount(otherLotto);
    }

    public boolean IsBonusMatch(BonusNum otherBonusNum) {
        return bonusNum.equals(otherBonusNum);
    }
}
