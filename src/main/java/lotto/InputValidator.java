package lotto;

import lotto.exception.NotNumberException;
import lotto.exception.NotThousandException;
import lotto.exception.WinningNumbersIllegalException;

public class InputValidator {
    public void validateInputPurchaseAmount(String input) {
        validateIsNumber(input);
        validateIsThousand(Integer.parseInt(input));
    }

    public void validateInputWinningNumbers(String input) {
        validateIsSeparateByComma(input);
    }

    public void validateInputBonusNumber() {
        throw new UnsupportedOperationException();
    }

    private void validateIsSeparateByComma(String input) {
        final String regex = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
        if (!input.matches(regex)) {
            throw new WinningNumbersIllegalException();
        }
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
