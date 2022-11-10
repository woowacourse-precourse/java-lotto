package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER_COUNT;

public class LottoValidator extends CommonValidator {

    public static boolean hasSixNumbers(List<Integer> numbers) {
        return numbers.size() == MAX_LOTTO_NUMBER_COUNT;
    }

    public static boolean hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);

        return duplicatedCheck.size() == MAX_LOTTO_NUMBER_COUNT;
    }

    public static boolean satisfyLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isRangeTrue(number)) {
                return false;
            }
        }

        return true;
    }
}
