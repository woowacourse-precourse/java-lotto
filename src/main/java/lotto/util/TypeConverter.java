package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    public static List<String> toStringListByComma(String winningNumber) {
        return Arrays.asList(winningNumber.split(","));
    }

    public static List<Integer> toIntegerListByComma(String winningNumber) {
        List<String> winningNumbers = Arrays.asList(winningNumber.split(","));
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
