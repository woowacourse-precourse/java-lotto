package lotto.domain.vo;

import static lotto.domain.constants.ErrorCode.NOT_CONTAINS_IN_LOTTO;
import static lotto.domain.constants.ErrorCode.NOT_IN_RANGE;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_END;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_START;

import java.util.List;

public class LottoWithBonus {

    private final Lotto lotto;
    private final int bonusNumber;

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
            throw NOT_CONTAINS_IN_LOTTO.getException();
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_START || bonusNumber > LOTTO_NUMBER_END) {
            throw NOT_IN_RANGE.getException();
        }
    }
}
