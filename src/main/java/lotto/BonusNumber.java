package lotto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto lottoNumbers) {
        validate(bonusNumber, lottoNumbers);
        this.bonusNumber = 0;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String number, Lotto lottoNumbers) {
        if (isStringEmpty(number) || !isDigit(number)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isStringEmpty(String number) {
        return number == null || number.isBlank();
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }
}
