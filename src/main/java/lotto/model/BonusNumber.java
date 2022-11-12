package lotto.model;

import lotto.util.Validator;
import lotto.view.View;

/*
 * 보너스 숫자 1개를 의미하는 객체
 */

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validateNumberRange(int number) {
        if (!Validator.isValidNumber(number)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }
    }

}
