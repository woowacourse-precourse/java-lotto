package lotto.validator;

import static lotto.validator.ErrorMessage.INVALID_SIZE;
import static lotto.validator.ErrorMessage.DUPLICATE_BONUS;
import static lotto.validator.ErrorMessage.DUPLICATED_NUMBERS;
import static lotto.validator.ErrorMessage.INVALID_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private static final int MAX_NUMBER = 45;

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBERS_SIZE = 6;

    public static void validateWinningNumber(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.forEach(LottoValidator::validateNumber);
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBERS_SIZE) {
            System.out.println(INVALID_SIZE.message());
            throw new IllegalArgumentException(
                INVALID_SIZE.message());
        }
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != numbers.size()) {
            System.out.println(DUPLICATED_NUMBERS.message());
            throw new IllegalArgumentException(
                DUPLICATED_NUMBERS.message()
            );
        }
    }

    static void validateNumber(final int number) {
        if (isOutOfBound(number)) {
            System.out.println(INVALID_RANGE.message());
            throw new IllegalArgumentException(
                INVALID_RANGE.message()
            );
        }
    }

    private static boolean isOutOfBound(final int number) {
        return number > MAX_NUMBER || number < MIN_NUMBER;
    }

    public static void validateBonusNumber(final int bonus,
        final List<Integer> winningNumbers) {

        validateNumber(bonus);
        if (winningNumbers.contains(bonus)) {
            System.out.println(DUPLICATE_BONUS.message());
            throw new IllegalArgumentException(
                DUPLICATE_BONUS.message()
            );
        }
    }
}
