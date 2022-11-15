package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static final String REGEX = ", ";

    public static List<Integer> separateNumbers(final String numbersText) {
        return Arrays.stream(numbersText.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static float getProfit(final float nowMoney, final float pastMoney) {
        return nowMoney / pastMoney;
    }
}
