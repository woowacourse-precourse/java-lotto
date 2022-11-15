package lotto.domain;

import java.util.List;

import static lotto.enumtype.LottoValidationMsg.*;

public class LottoWinningNumber {
    private static final int FIX_SIZE = 6;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (validateNumbersSize(numbers)) {
            throw new IllegalArgumentException(String.format(OVER_LOTTO_FIX_SIZE_EXCEPTION.getMessage(), FIX_SIZE));
        }

        if (validateDuplicateBonusNumber(numbers, bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
        }
    }

    private boolean validateNumbersSize(List<Integer> numbers) {
        return numbers.size() != FIX_SIZE;
    }

    private boolean validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
