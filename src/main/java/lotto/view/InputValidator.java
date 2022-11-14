package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

final class InputValidator {
    private static final String NULL_MESSAGE = "입력이 null 입니다";
    private static final String CANNOT_BE_INT = "숫자로 변환될 수 없습니다";
    private static final String CANNOT_BE_INTEGERS = "형식이 올바르지 않아 숫자들로 변환될 수 없습니다";
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");
    private static final Pattern SPLITTER_PATTERN = Pattern.compile("^([0-9],?)+[0-9]$");

    public static int toInt(String input) {
        canBeInt(input);
        return Integer.parseInt(input);
    }

    private static void canBeInt(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        if (!NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException(CANNOT_BE_INT);
        }
    }

    public static List<Integer> splitToIntegers(String input) {
        canBeIntegers(input);
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void canBeIntegers(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        if (!SPLITTER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(CANNOT_BE_INTEGERS);
        }
    }
}
