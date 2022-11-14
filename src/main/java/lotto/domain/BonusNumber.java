package lotto.domain;

import static lotto.io.Message.INPUT_FROM_1_TO_45;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        validateRange(number);
        this.bonusNumber = number;
    }

    public static BonusNumber saveBonusNumber(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validateRange(int number) {
        if (number < Lotto.MIN_VALUE || Lotto.MAX_VALUE < number) {
            throw new IllegalArgumentException(INPUT_FROM_1_TO_45);
        }
    }

}
