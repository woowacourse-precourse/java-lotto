package lotto.domain;

import lotto.exception.ErrorMessage;

public class Bonus {
    private final int number;
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;

    public Bonus(String number) {
        this.number = convertInteger(number);
        validate(this.number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < START_VALUE || number > END_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    private int convertInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

}
