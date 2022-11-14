package lotto.util;

import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    public static String removeSpace(String input) {
        return input.replaceAll("\\s", "");
    }

    public static List<Integer> formatWinningNumbersInput(String input) {
        return convertStringListToIntList(separateStringByComma(removeSpace(input)));
    }

    private static List<String> separateStringByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static List<Integer> convertStringListToIntList(List<String> list) {
        return list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static void verifyRangeOfLottoNumber(Integer number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }
}
