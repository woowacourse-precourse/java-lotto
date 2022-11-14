package lotto.utils;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.exception.ErrorMessage;

public class LottoNumbersValidator {

    public static void validate(List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_EXCEPTION.toString());
        }
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_EXCEPTION.toString());
        }
        if (isNotSameSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_EXCEPTION.toString());
        }
    }

    public static void validate(List<Integer> numbers, int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_EXCEPTION.toString());
        }
        if (hasDuplication(numbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_EXCEPTION.toString());
        }
    }

    private static boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoNumbersValidator::isOutOfRange);
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

    private static boolean isNotSameSize(List<Integer> numbers) {
        return numbers.size() != Lotto.LOTTO_NUMBERS_SIZE;
    }
}
