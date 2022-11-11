package lotto.validator;

import java.util.List;
import java.util.NoSuchElementException;

import static lotto.global.ExceptionConstants.CANNOT_SATISFY_NUMBER_RANGE;
import static lotto.global.ExceptionConstants.CAN_ONLY_INPUT_NUMBER;
import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.global.LottoConstants.MIN_LOTTO_NUMBER;

public class CommonValidator {

    public static void isAllNumber(long number) {
        char[] digits = String.valueOf(number).toCharArray();

        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException(CAN_ONLY_INPUT_NUMBER);
            }
        }
    }

    public static void isAllNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            isAllNumber(number);
        }
    }

    public static void isAllNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException(CAN_ONLY_INPUT_NUMBER);
            }
        }
    }

    public static void isRangeTrue(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(CANNOT_SATISFY_NUMBER_RANGE);
        }
    }
}
