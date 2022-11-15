package lotto;

import lotto.exception.utils.NotNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    public static final Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final String REGEX = ",";

    public static int textToNumber(String input) {
        if (!input.matches("^[0-9]+")) {
            throw new NotNumberException();
        }
        return Integer.parseInt(input);
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
