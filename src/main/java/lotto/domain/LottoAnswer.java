package lotto.domain;

import java.util.List;
import lotto.constant.Constant;
import lotto.constant.ExceptionMessage;

public class LottoAnswer {
    private final Lotto lottoAnswer;
    private final int bonusNumber;

    public LottoAnswer(Lotto lottoAnswer, int bonusNumber) throws Exception {
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
        validate();
    }

    private void validate() throws Exception {
        if (lottoAnswer.getLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_DUPLICATE.getString());
        }
        if (bonusNumber < Constant.LOTTO_MIN_VALUE.getValue() || bonusNumber > Constant.LOTTO_MAX_VALUE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_RANGE.getString());
        }
    }

    public boolean isNumberInAnswer(int number) {
        if (lottoAnswer.getLotto().contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isNumberEqaulToBonus(int number) {
        if (bonusNumber == number) {
            return true;
        }
        return false;
    }
}
