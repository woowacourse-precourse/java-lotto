package lotto.validation;

public class Validation {

    public void validateWinNumberInput(String input) {
        String[] token = input.split(",");
        if (token.length != 6) {
            throw new IllegalArgumentException();
        }

        for (String s : token) {
            validateStringIsNumeric(s);
        }

        for (String s : token) {
            int num = Integer.parseInt(s);
            validateNumberInBound(1, 45, num);
        }
    }

    private void validateNumberInput(String s) {
    }

    private void validateStringIsNumeric(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberInBound(int min, int max, int input) {
        if (input < min) {
            throw new IllegalArgumentException();
        }
        if (input > max) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumberInput() {

    }
}
