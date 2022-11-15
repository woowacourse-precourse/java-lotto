package lotto.util;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;

public class WinningNumberConverter {
    private static final String DELIMETER = ",";

    public static List<Integer> convertToImmutableIntegerList(String winningNumberInput) {
        return convertToImmutableIntegerList(convertToImmutableStringList(winningNumberInput));
    }

    public static List<Integer> convertToImmutableIntegerList(List<String> splitedWinningNumber) {
        return splitedWinningNumber.stream()
                .map(numberInput -> Integer.valueOf(numberInput))
                .collect(toUnmodifiableList());
    }

    public static List<String> convertToImmutableStringList(String winningNumberInput) {
        return List.of(winningNumberInput.split(DELIMETER));
    }
}
