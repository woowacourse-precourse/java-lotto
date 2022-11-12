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

    private static void validateNumber(int number) {
        if (!(LottoNumberConst.MIN_NUMBER_INT_VALUE <= number && number <= LottoNumberConst.MAX_NUMBER_INT_VALUE)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_RANGE.findExceptionMessage(number));
        }
    }
}
