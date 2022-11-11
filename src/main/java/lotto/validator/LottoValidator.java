package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.global.ExceptionConstants.CANNOT_DUPLICATED_NUMBER;
import static lotto.global.ExceptionConstants.CAN_ONLY_SIX_COUNT;
import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER_COUNT;

public class LottoValidator extends CommonValidator {

    public static void hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(CAN_ONLY_SIX_COUNT);
        }
    }

    public static void hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);

        if (duplicatedCheck.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(CANNOT_DUPLICATED_NUMBER);
        }
    }

    public static void satisfyLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            isRangeTrue(number);
        }
    }
}
