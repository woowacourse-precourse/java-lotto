package lotto.domain;

import lotto.constant.Message;
import lotto.util.Validator;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number){
        validateBonusNumber(number);
        this.number = number;
    }

    private void validateBonusNumber(int number) {
        if (Validator.isRangeOut(number)){
            Message.printInputErrorRangeOut();
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
