package lotto.model;

import java.util.List;
import lotto.constants.ErrorCode;

public class LottoWithBonus {

    Lotto lotto;
    int bonusNumber;

    public LottoWithBonus(Lotto lotto, int bonusNumber) {
        validateContains(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    private void validateContains(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw ErrorCode.NOT_CONTAINS_IN_LOTTO.getException();
        }
    }
}
