package lotto.domain;

import static lotto.io.Message.INPUT_FROM_1_TO_45;

public class BonusNumber {

    private final int number;

    private BonusNumber(String bonusNumber) {
        int n = Integer.parseInt(bonusNumber);
        validateRange(n);
        this.number = n;
    }

    public static BonusNumber saveBonusNumber(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getNumber() {
        return this.number;
    }

    private void validateRange(int number) {
        if (number < Lotto.MIN_VALUE || Lotto.MAX_VALUE < number) {
            throw new IllegalArgumentException(INPUT_FROM_1_TO_45);
        }
    }

}
