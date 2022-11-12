package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.Lotto.INVALID_RANGE_OF_LOTTO_NUMBER;
import static lotto.domain.policy.LottoPolicy.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.policy.LottoPolicy.MIN_NUMBER_OF_LOTTO;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRangeOfNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRangeOfNumbers(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER_OF_LOTTO || MAX_NUMBER_OF_LOTTO < bonusNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO_NUMBER);
        }
    }

    public boolean isIn(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
