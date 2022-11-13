package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public void validateInputPurchaseAmount(String input) {
        validateIsNumber(input);
        validateIsThousand(Integer.parseInt(input));
    }

    public void validateInputWinningNumbers(String input) {
        validateIsSeparateByComma(input);
    }
    public void validateWinningNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size()!= numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP.getMessage());
        }
    }

    public void validateInputBonusNumber(String input, Lotto winningNumber) {
        validateIsNumber(input);
        validateOutOfRange(Integer.parseInt(input));
        validateIsContainWinningNumber(Integer.parseInt(input), winningNumber);
    }

    private void validateIsContainWinningNumber(int input, Lotto winningNumber) {
        if(winningNumber.isContain(input)) {
            throw new IllegalArgumentException(ErrorMessage.IS_CONTAIN.getMessage());
        }
    }

    private void validateIsSeparateByComma(String input) {
        final String regex = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.REGEX_NOT_SATISFIED.getMessage());
        }
    }

    private void validateIsNumber(String input) {
        final String regex = "^[0-9]+$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void validateIsThousand(int input) {
        if(input < LottoSetting.PRICE.getValue() || input % LottoSetting.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND.getMessage());
        }
    }

    private void validateOutOfRange(Integer value) {
        if(value < LottoSetting.MIN_NUMBER.getValue() ||
                value > LottoSetting.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
