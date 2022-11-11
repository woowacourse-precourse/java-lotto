package lotto.domain;

import static lotto.constant.SystemMessage.BONUS_NUMBER_CONFLICT_ERROR;
import static lotto.constant.SystemMessage.BONUS_NUMBER_RANGE_ERROR;
import static lotto.constant.SystemMessage.BONUS_NUMBER_TYPE_ERROR;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;
import lotto.view.Output;

public class BonusNumber {

    private int bonusNumber;
    private WinningLotto winningLotto;

    public BonusNumber(String bonusNumber, WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        if (!isTypeValid(bonusNumber) || !isRangeValid(bonusNumber) || !isConflictWithWinningsValid(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return bonusNumber;
    }

    public static boolean isTypeValid(String bonusNumber) {
        boolean isType = bonusNumber.chars().allMatch(Character::isDigit);
        if (!isType) {
            Output.printError(BONUS_NUMBER_TYPE_ERROR);
        }
        return isType;
    }

    public static boolean isRangeValid(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        boolean isRange = (number >= MINIMUM_LOTTERY_NUMBER && number <= MAXIMUM_LOTTERY_NUMBER);
        if (!isRange) {
            Output.printError(BONUS_NUMBER_RANGE_ERROR);
        }
        return isRange;
    }

    public boolean isConflictWithWinningsValid(String bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        boolean isConflictWithWinnings = winningNumbers.stream()
                .noneMatch(number -> Integer.parseInt(bonusNumber) == number);
        if (!isConflictWithWinnings) {
            Output.printError(BONUS_NUMBER_CONFLICT_ERROR);
        }
        return isConflictWithWinnings;
    }
}
