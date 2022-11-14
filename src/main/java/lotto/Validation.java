package lotto;

public class Validation {

    public void checkNumeric(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Error.NOT_NUMERIC.message());
        }
    }

    public void checkNumberInRange(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.message());
        }
    }

    public void checkDividable(int number) throws IllegalArgumentException {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(Error.NOT_DIVIDABLE.message());
        }
    }

}
