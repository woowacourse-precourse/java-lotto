package lotto.model.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final String NUMBER_SEPARATOR = ",";

    private final Lotto lotto;

    public WinningNumber(String winningNumber) {
        List<Integer> numbers = Arrays.stream(winningNumber.split(NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lotto = new Lotto(numbers);
    }
}
