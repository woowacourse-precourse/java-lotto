package lotto.console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<Integer> parseIntList(String line, String regex) {
        return Arrays.stream(line.split(regex))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
