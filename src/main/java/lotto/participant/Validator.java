package lotto.participant;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.ErrorMessage.*;

public class Validator {

    public void validatePayment(String payment) {
        if (!isPositiveInteger(payment) || !isAvailablePayment(payment))
            throw new IllegalArgumentException(PAYMENT_UNIT_SHOULD_BE_1000.getErrorMessage());
    }

    private boolean isPositiveInteger(String string) {
        return string.matches("[1-9][0-9]+");
    }

    private boolean isAvailablePayment(String payment) {
        return Integer.parseInt(payment) % 1000 == 0;
    }

    public void validateWinningNumbers(String winningNumbers) {
        validateFormOfWinningNumbers(winningNumbers);
        validateValuesOfWinningNumbers(Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void validateFormOfWinningNumbers(String winningNumbers) {
        if (!winningNumbers.matches("[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*")) {
            throw new IllegalArgumentException(FORM_OF_WINNING_NUMBERS_IS_WRONG.getErrorMessage());
        }
    }

    private void validateValuesOfWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> collection = winningNumbers.stream()
                .filter(number -> 1 <= number && number <= 45)
                .collect(Collectors.toSet());
        if (collection.size() != 6) {
            throw new IllegalArgumentException(VALUES_OF_WINNING_NUMBERS_ARE_WRONG.getErrorMessage());
        }
    }

    public void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateFormOfBonusNumber(bonusNumber);
        validateDuplicationOfBonusNumber(Integer.parseInt(bonusNumber), winningNumbers);
    }

    private void validateFormOfBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches("[1-9][0-9]*") || !(Integer.parseInt(bonusNumber) <= 45)) {
            throw new IllegalArgumentException(FORM_OF_BONUS_NUMBER_IS_WRONG.getErrorMessage());
        }
    }

    private void validateDuplicationOfBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_AND_WINNING_NUMBER_IS_DUPLICATED.getErrorMessage());
        }
    }
}
