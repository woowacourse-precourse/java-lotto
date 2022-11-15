package lotto;

import java.util.List;

import static lotto.ErrorMsg.*;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(List<Integer> numbers, int number) {
        validateBonusDuplicate(numbers, number);
        validateBonusNumberCondition(number);
        this.bonusNumber = number;
    }

    private void validateBonusDuplicate(List<Integer> numbers, int number) {
        for (int compareNumber : numbers) {
            if (compareNumber == number) {
                throw new IllegalArgumentException(INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
            }
        }
    }

    private void validateBonusNumberCondition(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INPUT_NUMBER_CONDITION.getMessage());
        }
    }
}
