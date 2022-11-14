package lotto.utils;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.exception.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount % Lotto.LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_MESSAGE.toString());
        }
    }

    public static void validateLottoNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (isOutOfRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_MESSAGE.toString());
        }
        if (hasDuplication(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_MESSAGE.toString());
        }
        if (isNotValidSize(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_MESSAGE.toString());
        }
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_MESSAGE.toString());
        }
        if (hasDuplication(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_MESSAGE.toString());
        }
    }

    private static boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(InputValidator::isOutOfRange);
    }

    private static boolean isOutOfRange(Integer number) {
        return number < Lotto.LOWER_BOUND_NUMBER || number > Lotto.UPPER_BOUND_NUMBER;
    }


    private static boolean hasDuplication(List<Integer> numbers) {
        final Set<Integer> noDuplicatedNumbers = new HashSet<>(numbers);
        return noDuplicatedNumbers.size() != numbers.size();
    }

    private static boolean hasDuplication(List<Integer> numbers, Integer number) {
        return numbers.contains(number);
    }

    private static boolean isNotValidSize(List<Integer> numbers) {
        return numbers.size() != Lotto.LOTTO_NUMBERS_SIZE;
    }
}
