package lotto.util;

import static lotto.model.Yield.calculateYield;
import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;
import static lotto.util.ErrorMessage.ERROR_LOTTO_NUMBER_RANGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static final String PERCENT_FORMAT = "%.1f";
    public static final String SPACE_REGEX = "\\s";
    public static final String NO_SPACE = "";
    public static final String COMMA_REGEX = ",";
    public static final String CASH_PRIZE_REGEX = "\\B(?=(\\d{3})+(?!\\d))";


    public static String removeSpace(String input) {
        return input.replaceAll(SPACE_REGEX, NO_SPACE);
    }

    public static List<Integer> formatWinningNumbersInput(String input) {
        return Arrays.stream(removeSpace(input).split(COMMA_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void verifyRangeOfLottoNumber(Integer number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public static String formatYield(double totalPurchase, double totalRevenue) {
        return String.format(PERCENT_FORMAT, calculateYield(totalPurchase, totalRevenue));
    }

    public static String formatCashPrize(int cashPrize) {
        return String.valueOf(cashPrize).replaceAll(CASH_PRIZE_REGEX, COMMA_REGEX);
    }
}
