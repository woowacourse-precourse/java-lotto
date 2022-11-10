package lotto.validator;

import java.util.List;

public class InputValidator {

    public static boolean restEqualZero(long dividend, long divisor) {
        return dividend % divisor == 0;
    }

    public static boolean isZero(long number) {
        return number == 0;
    }

    public static boolean hasSixNumbers(List<Integer> numbers) {
        return numbers.size() == 6;
    }
}
