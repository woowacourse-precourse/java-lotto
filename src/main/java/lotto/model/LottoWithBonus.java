package lotto.model;

import java.util.List;
import lotto.constants.ErrorCode;
import lotto.constants.LottoConstants;

public class LottoWithBonus {

    Lotto lotto;
    int bonusNumber;

    public LottoWithBonus(Lotto lotto, int bonusNumber) {
        validateContains(lotto, bonusNumber);
        validateRange(bonusNumber);
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

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_START
                || bonusNumber > LottoConstants.LOTTO_NUMBER_END) {
            throw ErrorCode.NOT_IN_RANGE.getException();
        }
    }
}
