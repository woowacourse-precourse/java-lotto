package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;

    public static boolean restEqualZero(long dividend, long divisor) {
        return dividend % divisor == 0;
    }

    public static boolean isZero(long number) {
        return number == 0;
    }

    public static boolean hasSixNumbers(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public static boolean satisfyLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(!isRangeTrue(number)) return false;
        }

        return true;
    }

    private static boolean isRangeTrue(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
    }

    public static boolean hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>(numbers);

        return duplicatedCheck.size() == MAX_LOTTO_NUMBER_COUNT;
    }
}
