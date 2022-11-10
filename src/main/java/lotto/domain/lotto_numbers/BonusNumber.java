package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.INVALID_RANGE_OF_LOTTO_NUMBER;
import static lotto.domain.lotto_numbers.LottoNumbersPolicy.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.lotto_numbers.LottoNumbersPolicy.MIN_NUMBER_OF_LOTTO;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRangeOfNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    void validateRangeOfNumbers(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER_OF_LOTTO || MAX_NUMBER_OF_LOTTO < bonusNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO_NUMBER);
        }
    }

    public boolean isIn(Lotto winningNumber) {
        return winningNumber.contains(bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        if (isIn(lotto)) {
            return 1;
        }
        return 0;
    }
}
