package lotto.validator;

import java.util.List;

import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.global.LottoConstants.MIN_LOTTO_NUMBER;

public class CommonValidator {

    public static boolean isAllNumber(long number) {
        char[] digits = String.valueOf(number).toCharArray();

        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAllNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isAllNumber(number)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isRangeTrue(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
    }
}
