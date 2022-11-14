package lotto.util.number;

import java.util.stream.IntStream;
import lotto.domain.number.LottoNumber;
import lotto.util.message.LottoExceptionMessageUtils;

public class LottoNumberFactory {

    private static final LottoNumber[] LOTTO_NUMBERS = new LottoNumber[LottoNumberConst.MAX_NUMBER_INT_VALUE + 1];

    static {
        IntStream.rangeClosed(LottoNumberConst.MIN_NUMBER_INT_VALUE, LottoNumberConst.MAX_NUMBER_INT_VALUE)
                .forEach(number -> LOTTO_NUMBERS[number] = new LottoNumber(number));
    }

    private LottoNumberFactory() {
    }

    public static LottoNumber numberOf(int number) {
        validateIndex(number);
        return LOTTO_NUMBERS[number];
    }

    public static LottoNumber numberOf(String number) {
        int targetNumber = getNumber(number);

        validateIndex(targetNumber);
        return LOTTO_NUMBERS[targetNumber];
    }

    private static void validateIndex(int number) {
        if (!isValidIndexRange(number)) {
            throw new IllegalArgumentException(LottoExceptionMessageUtils
                    .INVALID_NUMBER_RANGE.findExceptionMessage(number));
        }
    }

    private static boolean isValidIndexRange(int number) {
        return LottoNumberConst.MIN_NUMBER_INT_VALUE <= number && number <= LottoNumberConst.MAX_NUMBER_INT_VALUE;
    }

    private static int getNumber(String otherTypeNumber) {
        int number;

        try {
            number = Integer.parseInt(otherTypeNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessageUtils
                    .INVALID_NUMBER_FORMAT.findExceptionMessage(otherTypeNumber));
        }
        return number;
    }
}
