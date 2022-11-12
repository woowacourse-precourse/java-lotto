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
        if (isStringEmpty(number)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isStringEmpty(String numbers) {
        return numbers == null || numbers.isBlank();
    }
}
