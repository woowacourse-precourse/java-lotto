package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static String removeSpace(String input) {
        return input.replaceAll("\\s", "");
    }

    public static List<Integer> formatInput(String input) {
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
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
