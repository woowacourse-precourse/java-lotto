package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<Integer> getParsedNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(((String s) -> Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    public static String getConcatenatedString(List<Integer> numbers) {
        return String.join(",", numbers.stream()
                .map((Integer number) -> Integer.toString(number))
                .collect(Collectors.toList()));
    }
}
