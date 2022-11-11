package lotto.domain;

import static lotto.constant.SystemMessage.BONUS_NUMBER_CONFLICT_ERROR;
import static lotto.constant.SystemMessage.BONUS_NUMBER_RANGE_ERROR;
import static lotto.constant.SystemMessage.BONUS_NUMBER_TYPE_ERROR;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;
    private WinningLotto winningLotto;

    public BonusNumber(String bonusNumber, WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        checkTypeValid(bonusNumber);
        checkRangeValid(bonusNumber);
        checkConflictWithWinningsValid(bonusNumber);
    }

    public int getNumber() {
        return bonusNumber;
    }

    public static void checkTypeValid(String bonusNumber) {
        boolean isType = bonusNumber.chars().allMatch(Character::isDigit);
        if (!isType) {
            throw new IllegalArgumentException(BONUS_NUMBER_TYPE_ERROR);
        }
    }

    public static void checkRangeValid(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        boolean isRange = (number >= MINIMUM_LOTTERY_NUMBER && number <= MAXIMUM_LOTTERY_NUMBER);
        if (!isRange) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR);
        }
    }

    public void checkConflictWithWinningsValid(String bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        boolean isConflictWithWinnings = winningNumbers.stream()
                .noneMatch(number -> Integer.parseInt(bonusNumber) == number);
        if (!isConflictWithWinnings) {
            throw new IllegalArgumentException(BONUS_NUMBER_CONFLICT_ERROR);
        }
    }
}
