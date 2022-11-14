package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class PurchaseLotto extends LottoWithBonusNum {

    public PurchaseLotto(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers, bonusNumber);
    }

    public static PurchaseLotto makeRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);
        return new PurchaseLotto(numbers.subList(0, numbers.size() - 1), numbers.get(numbers.size() - 1));
    }

    public int matchCount(Lotto otherLotto) {
        return lotto.matchCount(otherLotto);
    }

    public boolean IsBonusMatch(BonusNum otherBonusNum) {
        return bonusNum.equals(otherBonusNum);
    }
}
