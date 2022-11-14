package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParsingUtils {
    private static final String COMMA = ",";

    public static List<Integer> parseToNumber(String input) {
        String[] stringParsedInput = input.split(COMMA);
        return Arrays.stream(stringParsedInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
