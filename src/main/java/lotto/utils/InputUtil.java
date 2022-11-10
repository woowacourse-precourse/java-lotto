package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validator.InputValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.exception.ExceptionConstants.CANNOT_DUPLICATED_NUMBER;
import static lotto.exception.ExceptionConstants.CANNOT_INPUT_ZERO;
import static lotto.exception.ExceptionConstants.CANNOT_SATISFY_NUMBER_RANGE;
import static lotto.exception.ExceptionConstants.CAN_ONLY_MULTIPLY_1000;
import static lotto.exception.ExceptionConstants.CAN_ONLY_SIX_COUNT;

public class InputUtil {

    public static final int LOTTO_PRICE = 1000;
    public static final String WINNING_NUMBER_DELIM = ",";

    private static List<Integer> winningNumbers;

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

    public static Lotto inputWinningLottoNumber() {

        winningNumbers = Stream.of(Console.readLine().split(WINNING_NUMBER_DELIM))
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

        return new Lotto(winningNumbers);
    }

    public static Integer inputBounsLottoNumber() {

        int bounsNumber = Integer.parseInt(Console.readLine());

        if (winningNumbers.contains(bounsNumber)) {
            throw new IllegalArgumentException(CANNOT_DUPLICATED_NUMBER);
        }

        if (!InputValidator.isRangeTrue(bounsNumber)) {
            throw new IllegalArgumentException(CANNOT_SATISFY_NUMBER_RANGE);
        }

        return bounsNumber;
    }
}
