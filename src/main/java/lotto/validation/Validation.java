package lotto.validation;

public class Validation {

    public void validateWinNumberInput(String input) {
        String[] token = input.split(",");
        if (token.length != 6) {
            throw new IllegalArgumentException();
        }

        for (String s : token) {
            validateNumberInput(s);
        }
    }

    private void validateNumberInput(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStringIsNumeric(String str) {

    }

    public void validateBonusNumberInput() {

    }
}
