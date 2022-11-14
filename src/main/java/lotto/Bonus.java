package lotto;

import static lotto.ErrorMessages.*;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    public int getNumber() {
        return number;
    }
}
