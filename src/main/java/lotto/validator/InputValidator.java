package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER_COUNT;
import static lotto.global.LottoConstants.MIN_LOTTO_NUMBER;

public class InputValidator {



    public static boolean restEqualZero(long dividend, long divisor) {
        return dividend % divisor == 0;
    }

    public static boolean isZero(long number) {
        return number == 0;
    }

    public static boolean hasSixNumbers(List<Integer> numbers) {
        return numbers.size() == MAX_LOTTO_NUMBER_COUNT;
    }

    public static boolean satisfyLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isRangeTrue(number)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isRangeTrue(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
    }

    public static boolean hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);

        return duplicatedCheck.size() == MAX_LOTTO_NUMBER_COUNT;
    }
}
