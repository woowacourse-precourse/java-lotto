package lotto.validator;

public class BuyAmountValidator {
    public void validateInvalidNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDivideBy1000(int inputNumber) {
        if (!divideBy1000(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePositiveNumber(int inputNumber) {
        if (inputNumber < 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean divideBy1000(int inputNumber) {
        return inputNumber % 1000 == 0;
    }
}
