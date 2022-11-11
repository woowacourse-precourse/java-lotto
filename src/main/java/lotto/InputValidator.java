package lotto;

import lotto.exception.NotNumberException;

public class InputValidator {
    public void validateInputPurchaseAmount(String input) {
        throw new UnsupportedOperationException();
    }

    public void validateInputWinningNumbers() {
        throw new UnsupportedOperationException();
    }

    public void validateInputBonusNumber() {
        throw new UnsupportedOperationException();
    }

    private void validateIsNumber(String input) {
        final String regex = "^[0-9]+$";
        if (!input.matches(regex)) {
            throw new NotNumberException();
        }
    }
}
