package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static final String SEPERATOR = ",";

    public static List<Integer> getParsedNumbers(String input) {
        if (input.isEmpty() || input.isBlank()) {
            return new ArrayList<>();
        }

        return Arrays.stream(input.split(SEPERATOR))
                .map(((String s) -> Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    public static String getConcatenatedString(List<Integer> numbers) {
        return String.join(SEPERATOR, numbers.stream()
                .map((Integer number) -> Integer.toString(number))
                .collect(Collectors.toList()));
    }
}
