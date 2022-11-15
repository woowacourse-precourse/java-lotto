package lotto;

import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.ErrorMessages.*;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    public int getNumber() {
        return number;
    }
}
