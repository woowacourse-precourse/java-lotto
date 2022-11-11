package lotto.model.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String NUMBER_SEPARATOR = ",";

    private final List<Integer> numbers;

    public WinningNumber(String winningNumber) {
        numbers = Arrays.stream(winningNumber.split(NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
