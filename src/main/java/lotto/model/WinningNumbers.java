package lotto.model;

import java.util.List;

public class WinningNumbers {
    private static final String ERR_DUPLICATE_BONUS_NUMBER = "[ERROR] 당첨 번호와 보너스 번호가 중복입니다.";
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        validateNoDuplicateBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateNoDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_BONUS_NUMBER);
        }
    }

    private boolean isWinningNumber(int number) {
        return winningNumbers.contains(number);
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
