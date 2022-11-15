package lotto.model;

import static lotto.enums.PrintMsg.*;
import static lotto.enums.Constant.*;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PRICE_OF_LOTTO.getValue() != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_PURCHASE_AMOUNT_IS_NOT_DIVIDED_BY_1000.getMessage());
        }
    }

    public void validateWinningNumber(List<Integer> winningNumber) {
        validateSizeOfWinningNumber(winningNumber);
        validateWinningNumberBetween1And45(winningNumber);
        validateDuplicateWinningNumber(winningNumber);
    }

    private void validateSizeOfWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != CORRECT_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_WINNING_NUMBER_IS_NOT_SIX.getMessage());
        }
    }

    private void validateWinningNumberBetween1And45(List<Integer> winningNumber) {
        List<Integer> filter_numbers = winningNumber.stream()
                .filter(number -> number < START_NUMBER.getValue() || number > END_NUMBER.getValue())
                .collect(Collectors.toList());
        if (!filter_numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_WINNING_NUMBER_IS_NOT_BETWEEN_1_AND_45.getMessage());
        }
    }

    private void validateDuplicateWinningNumber(List<Integer> winningNumber) {
        List<Integer> distinct_WinningNumber = winningNumber.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinct_WinningNumber.size() != CORRECT_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_WINNING_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        validateBonusNumberBetween1And45(bonusNumber);
        validateBonusNumberNotInWinningNumber(bonusNumber, winningNumber);
    }

    private void validateBonusNumberBetween1And45(int bonusNumber) {
        if (bonusNumber < START_NUMBER.getValue() || bonusNumber > END_NUMBER.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_BONUS_NUMBER_IS_NOT_BETWEEN_1_AND_45.getMessage());
        }
    }

    private void validateBonusNumberNotInWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_BONUS_NUMBER_IS_NOT_CONTAINED_WINNING_NUMBER.getMessage());
        }
    }
}
