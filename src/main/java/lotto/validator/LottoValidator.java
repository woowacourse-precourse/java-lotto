package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static lotto.global.ExceptionConstants.CANNOT_DUPLICATED_NUMBER;
import static lotto.global.ExceptionConstants.CAN_ONLY_SIX_COUNT;
import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER_COUNT;

public class LottoValidator extends CommonValidator {

    public static void validate(List<Integer> numbers) {
        try {
            isAllNumber(numbers);
        } catch (IllegalArgumentException ignore) {
            throw new NoSuchElementException();
        }
        hasSixNumbers(numbers);
        hasDuplicatedNumber(numbers);
        satisfyLottoNumberRange(numbers);
    }

    private static void hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            System.out.println(CAN_ONLY_SIX_COUNT);
            throw new IllegalArgumentException();
        }
    }

    private static void hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);

        if (duplicatedCheck.size() != MAX_LOTTO_NUMBER_COUNT) {
            System.out.println(CANNOT_DUPLICATED_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static void satisfyLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            isRangeTrue(number);
        }
    }
}
