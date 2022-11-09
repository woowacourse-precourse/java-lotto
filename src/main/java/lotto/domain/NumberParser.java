package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {

    public static List<Integer> numbers(String formattedNumber) {
        String[] formattedNumbers = formattedNumber.split(",");
        return Arrays.stream(formattedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
