package lotto.screen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOResolve {
    public static Integer toInteger(String inputValue) {
        try {
            return Integer.valueOf(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static List<Integer> splitIntegers(String inputValue) {
        try {
            return split(inputValue);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    public static String joinStrings(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(strings).forEach(string -> stringBuilder.append(string));
        return stringBuilder.toString();
    }

    private static List<Integer> split(String inputValue) {
        return Arrays
                .stream(inputValue.split(","))
                .map(value -> Integer.valueOf(value))
                .collect(Collectors.toList());
    }
}
