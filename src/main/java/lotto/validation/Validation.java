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

    private boolean validateNumberInBound(int min, int max, int input) {
        if (input < min) {
            return false;
        }
        if (input > max) {
            return false;
        }
        return true;
    }

    public void validateBonusNumberInput() {

    }
}
