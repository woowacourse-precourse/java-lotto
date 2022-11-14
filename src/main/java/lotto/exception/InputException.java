package lotto.exception;

import static lotto.exception.ErrorMessage.*;

public class InputException extends IllegalArgumentException {

    public void notDigitException(String inputString) {
        if (inputString.chars().allMatch(Character::isDigit)) {
            return;
        }
        throw new IllegalArgumentException(NOT_DIGIT.getMessage());
    }

    public void notThousandMoneys(int money) {
        if (money % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(NOT_THOUSAND_MONEY.getMessage());
    }
}
