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

    public void validateInputBonusNumber(String input, Lotto winningNumber) {
        validateIsNumber(input);
        validateOutOfRange(Integer.parseInt(input));
        validateIsContainWinningNumber(Integer.parseInt(input), winningNumber);
    }

    private void validateIsContainWinningNumber(int input, Lotto winningNumber) {
        if(winningNumber.isContain(input)) {
            throw new IllegalArgumentException("이미 당첨번호에 존재합니다.");
        }
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

    private void validateOutOfRange(Integer value) {
        if(value < 1 || value > 45) {
            throw new IllegalArgumentException("숫자 범위가 초과되었습니다.");
        }
    }
}
