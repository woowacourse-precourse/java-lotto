package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");
    private static final Pattern SPLITTER_PATTERN = Pattern.compile("^([0-9],?)+[0-9]$");

    public static int toInt(String input) {
        canBeInt(input);
        return Integer.parseInt(input);
    }

    private static void canBeInt(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (!NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        if (!SPLITTER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
