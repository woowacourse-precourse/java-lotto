package lotto.domain;

import static lotto.constant.LottoGameRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_MIN_NUMBER;
import static lotto.domain.ErrorMessage.BONUS_NUMBER_SIZE_ERROR;
import static lotto.domain.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int number) {
        validate(number);
        this.bonusNumber = number;
    }

    private void validate(int number) {
        isOneNumber(number);
        isInRange(number);
    }

    private void isOneNumber(int number) {
        if ((int)(Math.log10(number)+1) != 1) {
            throw new IllegalArgumentException((BONUS_NUMBER_SIZE_ERROR.toString()));
        }
    }

    private void isInRange(int number) {
        if (!(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR.toString());
        }
    }
}
