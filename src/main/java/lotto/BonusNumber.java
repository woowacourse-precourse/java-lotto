package lotto;

import static lotto.utils.Messages.ERROR_RANGE_MESSAGE;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if(bonusNumber<1 || bonusNumber >45){
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE);
        }
    }
}
