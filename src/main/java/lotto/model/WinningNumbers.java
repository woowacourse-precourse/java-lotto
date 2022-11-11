package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> regularNumbers;
    private final int bonusNumber;
    public WinningNumbers(List<Integer> regularNumbers, int bonusNumber) {
        this.regularNumbers = regularNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return regularNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }

    public CompareResult judgeMatchOrBonus(Integer number, CompareResult compareResult) {
        if (isWinningNumber(number)) {
            return compareResult.increaseMatchCount();
        }
        if (isBonusNumber(number)) {
            return compareResult.bonusNumberFound();
        }

        return compareResult;
    }
}
