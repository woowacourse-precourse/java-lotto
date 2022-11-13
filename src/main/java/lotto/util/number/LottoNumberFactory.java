package lotto.util.number;

import java.util.stream.IntStream;
import lotto.domain.LottoNumber;
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
        validateNumber(number);
        return LOTTO_NUMBERS[number];
    }

    public static LottoNumber numberOf(String number) {
        int targetNumber = getNumber(number);

        validateNumber(targetNumber);
        return LOTTO_NUMBERS[targetNumber];
    }

    private static void validateNumber(int number) {
        if (!(LottoNumberConst.MIN_NUMBER_INT_VALUE <= number && number <= LottoNumberConst.MAX_NUMBER_INT_VALUE)) {
            throw new IllegalArgumentException(LottoExceptionMessageUtils
                    .INVALID_NUMBER_RANGE.findExceptionMessage(number));
        }
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
