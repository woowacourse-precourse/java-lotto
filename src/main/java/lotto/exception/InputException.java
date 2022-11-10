package lotto.exception;

public class InputException extends IllegalArgumentException {

    public boolean notDigitException(String inputString) {
        if (inputString.chars().allMatch(Character::isDigit)) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.getMessage());
    }

    public boolean notThousandMoneys(int money) {
        if (money % 1000 != 0) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_MONEY.getMessage());
    }
}
