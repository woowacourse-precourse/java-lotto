package lotto.domain.lottery;

import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;

public class BonusNumber {

    private static final String BONUS_NUMBER_CONFLICT_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다";
    private static final String BONUS_NUMBER_RANGE_ERROR = "보너스 번호는 1부터 45까지의 수여야 합니다";
    private static final String BONUS_NUMBER_TYPE_ERROR = "보너스 번호에 문자가 포함될 수 없습니다";
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

    private void checkTypeValid(String bonusNumber) {
        boolean isType = bonusNumber.chars().allMatch(Character::isDigit);
        if (!isType) {
            throw new IllegalArgumentException(BONUS_NUMBER_TYPE_ERROR);
        }
    }

    private void checkRangeValid(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        boolean isRange = (number >= MINIMUM_LOTTERY_NUMBER && number <= MAXIMUM_LOTTERY_NUMBER);
        if (!isRange) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR);
        }
    }

    private void checkConflictWithWinningsValid(String bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        boolean isConflictWithWinnings = winningNumbers.stream()
                .noneMatch(number -> Integer.parseInt(bonusNumber) == number);
        if (!isConflictWithWinnings) {
            throw new IllegalArgumentException(BONUS_NUMBER_CONFLICT_ERROR);
        }
    }
}
