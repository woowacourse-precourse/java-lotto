package lotto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;
    private static final ExceptionHandler exceptionHandler = new ExceptionHandler();

    public BonusNumber(List<Integer> numbers, int number) {
        validateBonusDuplicate(numbers, number);
        validateBonusNumberCondition(number);
        this.bonusNumber = number;
    }

    private void validateBonusDuplicate(List<Integer> numbers, int number) {
        for (int compareNumber : numbers) {
            if (compareNumber == number) {
                exceptionHandler.foolExceaption("lottoDuplicate");
            }
        }
    }

    private void validateBonusNumberCondition(int number) {
        if (number < 1 || number > 45) {
            exceptionHandler.foolExceaption("lottoCondition");
        }
    }
}
