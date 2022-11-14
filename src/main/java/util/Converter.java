package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static final String COMMA = ",";

    public static List<Integer> splitFromString(String readLine) {
        return Arrays.stream(readLine.split(COMMA))
                .map(String::strip)
                .peek(InputValidator::validateDigits)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
