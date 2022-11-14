package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> regularNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> regularNumbers, int bonusNumber) {
        this.regularNumbers = regularNumbers;
        this.bonusNumber = bonusNumber;
    }

    private boolean isWinningNumber(int number) {
        return regularNumbers.contains(number);
    }

    private boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }

    public CompareResult judgeWinningNumberOrBonus(Integer number, CompareResult compareResult) {
        if (isWinningNumber(number)) {
            return compareResult.oneMoreNumberMatched();
        }
        if (isBonusNumber(number)) {
            return compareResult.bonusNumberFound();
        }

        return compareResult;
    }
}
