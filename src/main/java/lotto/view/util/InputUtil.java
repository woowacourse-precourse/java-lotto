package lotto.view.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

    public static List<Integer> convertStringSplitToList(String input) {
        try {
            List<String> numbers = Arrays.asList(input.split(","));

            return numbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
