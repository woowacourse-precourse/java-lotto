package lotto.Model;

import lotto.Model.enums.ErrorMessage;

import java.util.List;

public class Bonus {
    private final int bonus;

    public Bonus(int number, List<Integer> lottoNumbers) {
        validate(number, lottoNumbers);
        this.bonus = number;
    }

    private void validate(int number, List<Integer> lottoNumbers) {
        validateDuplicate(number, lottoNumbers);
        validateRange(number);
    }

    void validateDuplicate(int number, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_ERROR.getMessage());
        }
    }

    void validateRange(int number) {
        if (number < 1 | number > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE_ERROR.getMessage());
        }
    }

    public int getBonus() {
        return this.bonus;
    }
}
