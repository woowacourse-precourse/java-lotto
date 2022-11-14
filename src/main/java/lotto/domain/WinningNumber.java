package lotto.domain;

import lotto.constant.ValidationErrorMessage;

import java.util.List;

public class WinningNumber extends Lotto {
    static final String INVALID_RANGE_ERROR = ValidationErrorMessage.INVALID_RANGE.getErrorMessage();
    static final String DUPLICATE_BONUS_NUMBER_ERROR = ValidationErrorMessage.DUPLICATE_BONUS_NUMBER.getErrorMessage();

    private int bonusNumber;

    public WinningNumber (List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (!DomainValidator.hasCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }

        if (DomainValidator.hasNumberInLottery(numbers, bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
