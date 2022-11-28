package lotto.utils.number;

import java.util.stream.IntStream;
import lotto.domain.number.LottoNumber;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;

public class LottoNumberFactory {

    private static final LottoNumber[] LOTTO_NUMBERS = new LottoNumber[LottoConst.MAX_NUMBER_VALUE + 1];

    static {
        IntStream.rangeClosed(LottoConst.MIN_NUMBER_VALUE, LottoConst.MAX_NUMBER_VALUE)
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
            throw new IllegalArgumentException(ExceptionMessageUtil
                    .WRONG_NUMBER_RANGE.findFullMessage());
        }
    }

    private static boolean isValidIndexRange(int number) {
        return LottoConst.MIN_NUMBER_VALUE <= number && number <= LottoConst.MAX_NUMBER_VALUE;
    }

    private static int getNumber(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_NUMBER_FORMAT.findFullMessage(), e);
        }
    }
}
