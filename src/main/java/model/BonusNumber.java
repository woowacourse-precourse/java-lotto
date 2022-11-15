package model;

import static constant.Config.MAX_NUMBER;
import static constant.Config.MIN_NUMBER;

public class BonusNumber {
    private static final String RANGE_ERROR = String.format("보너스 번호는 %d~%d 범위여야 합니다.", MIN_NUMBER, MAX_NUMBER);
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
