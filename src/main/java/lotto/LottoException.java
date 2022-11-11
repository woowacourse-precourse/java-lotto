package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoException {

    public LottoException() {
    }

    public void exceptionLottoByDuplicatedNumber(List<Integer> computerLotto) {
        HashSet<Integer> lottoHashSet = new HashSet<Integer>(computerLotto);
        if (lottoHashSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void exceptionBonusNumberByDuplicatedLotto(List<Integer> computerLotto, int bonusNumber) {
        if (computerLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
