package lotto.domain.lotto;

import lotto.global.message.ErrorMessage;
import lotto.global.message.Number;

public class BonusBall {

    private final Integer number;

    public BonusBall(Integer number) {
        validate(number);
        this.number = number;
    }

    public static BonusBall create(Integer number) {
        return new BonusBall(number);
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(Integer number) {
        if (number < Number.MIN_NUMBER_RANGE || number > Number.MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
