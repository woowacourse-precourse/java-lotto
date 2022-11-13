package lotto.domain.lotto;

public class PurchaseLotto extends LottoWithBonusNum {
    
    public int matchCount(Lotto otherLotto) {
        return lotto.matchCount(otherLotto);
    }

    public boolean IsBonusMatch(BonusNum otherBonusNum) {
        return bonusNum.equals(otherBonusNum);
    }
}
