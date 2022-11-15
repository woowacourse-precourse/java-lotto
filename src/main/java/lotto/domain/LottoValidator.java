package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.NumbersDuplicatedException;
import lotto.exception.NumbersNotMatchDigitException;
import lotto.rule.LottoRange;

public class LottoValidator {

    private static final int LIMIT = 1;

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumbersMatchDigit(numbers);
        validateNumberDuplicated(numbers);
        validateNumbersOutOfRange(numbers);
    }

    private static void validateNumberDuplicated(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> Collections.frequency(numbers, number) > LIMIT)) {
            throw new NumbersDuplicatedException();
        }
    }

    private static void validateNumbersMatchDigit(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new NumbersNotMatchDigitException();
        }
    }

    private static void validateNumbersOutOfRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(LottoRange::isOutOfRange)) {
            throw new NumberOutOfRangeException();
        }
    }
}
