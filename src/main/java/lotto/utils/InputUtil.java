package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionConstants;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.exception.ExceptionConstants.*;

public class InputUtil {

    public static final int LOTTO_PRICE = 1000;
    public static final String WINNING_NUMBER_DELIM = ",";

    public static long inputLottoPurchaseAmount() {

        long purchasePrice = Long.parseLong(Console.readLine());

        if (InputValidator.isZero(purchasePrice)) {
            throw new IllegalArgumentException(CANNOT_INPUT_ZERO);
        }

        if (InputValidator.restEqualZero(purchasePrice, LOTTO_PRICE)) {
            throw new IllegalArgumentException(CAN_ONLY_MULTIPLY_1000);
        }

        return purchasePrice;
    }

    public static List<Integer> inputWinningLottoNumber() {

        List<Integer> winningNumbers = Stream.of(Console.readLine().split(WINNING_NUMBER_DELIM))
                                             .map(Integer::parseInt)
                                             .collect(Collectors.toList());

        if (!InputValidator.hasSixNumbers(winningNumbers)) {
            throw new IllegalArgumentException(CAN_ONLY_SIX_COUNT);
        }

        if (!InputValidator.hasDuplicatedNumber(winningNumbers)) {
            throw new IllegalArgumentException(CANNOT_DUPLICATED_NUMBER);
        }

        if (!InputValidator.satisfyLottoNumberRange(winningNumbers)) {
            throw new IllegalArgumentException(CANNOT_SATISFY_NUMBER_RANGE);
        }

        return winningNumbers;
    }
}
