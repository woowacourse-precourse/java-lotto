package lotto.domain;

import lotto.service.Validate;

public class BonusNumber {

    private int number;
    private final Validate validate = new Validate();

    public BonusNumber(int number) {
        validate.IsCorrectRangeBonusNumber(number);
        this.number = number;
    }

    public BonusNumber(String s) {
        validate.IsRightFormatBonusNumber(s);
        this.number = Integer.parseInt(s);
    }

    public int getNumber() { return this.number;}
}
