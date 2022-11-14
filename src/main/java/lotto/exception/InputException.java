package lotto.exception;

import java.util.List;

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

    public void duplicateNumberException(List<Integer> numbers) {
        boolean[] checkNumbers = new boolean[46];
        for (Integer number : numbers) {
            if (checkNumbers[number]) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
            }
            checkNumbers[number] = true;
        }
    }
}
