package lotto;

import lotto.exception.NotNumberException;
import lotto.exception.NotThousandException;

public class InputValidator {
    public void validateInputPurchaseAmount(String input) {
        validateIsNumber(input);
        validateIsThousand(Integer.parseInt(input));
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

    private void validateIsThousand(int input) {
        if(input < InputManager.LOTTO_PRICE || input % InputManager.LOTTO_PRICE != 0) {
            throw new NotThousandException();
        }
    }

}
