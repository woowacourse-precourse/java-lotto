package lotto.util;

import static lotto.domain.Yield.calculateYield;
import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    public static final String PERCENT_FORMAT = "%.1f";
    public static final String SPACE_REGEX = "\\s";
    public static final String NO_SPACE = "";
    public static final String COMMA_REGEX = ",";

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE_REGEX, NO_SPACE);
    }

    public static List<Integer> formatWinningNumbersInput(String input) {
        return convertStringListToIntList(separateStringByComma(removeSpace(input)));
    }

    private static List<String> separateStringByComma(String input) {
        return Arrays.asList(input.split(COMMA_REGEX));
    }

    private static List<Integer> convertStringListToIntList(List<String> list) {
        return list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static void verifyRangeOfLottoNumber(Integer number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new IllegalArgumentException("1부터 45 사이의 숫자만 입력 가능합니다.");
        }
    }

    public static String formatYield(double totalPurchase, double totalRevenue) {
        return String.format(PERCENT_FORMAT, calculateYield(totalPurchase, totalRevenue));
    }
}
