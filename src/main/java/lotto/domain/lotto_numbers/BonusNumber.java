package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.INVALID_RANGE_OF_LOTTO_NUMBER;

public class BonusNumber {

    private static final int MIN_NUMBER_OF_LOTTO = 1;
    private static final int MAX_NUMBER_OF_LOTTO = 45;

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

    public boolean isIn(WinningNumbers winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }
}
