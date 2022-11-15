package lotto.domain;

import lotto.constant.ErrorMessage;
import java.util.List;

public class WinningNumber extends Lotto {
    private static final String INVALID_RANGE_ERROR_MESSAGE = ErrorMessage.INVALID_RANGE.getErrorMessage();
    private static final String DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = ErrorMessage.DUPLICATE_BONUS_NUMBER.getErrorMessage();

    private int bonusNumber;

    public WinningNumber (List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        if (!DomainValidator.hasCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }

        if (DomainValidator.hasNumberInLottery(numbers, bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
