package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    public static final Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String REGEX = ",";

    public static int textToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력해야 합니다.");
        }
    }

    public static List<Integer> separateNums(String input) {
        return Arrays.asList(input.split(REGEX))
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static double getRateOfReturn(double money, double prize) {
        return (prize / money) * 100;
    }
}
