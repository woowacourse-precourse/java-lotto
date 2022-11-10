package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private List<Integer> numbers;

    public void setWinningNumbers(String input) {
        setNumbers(input);
    }

    private void setNumbers(String input) {
        numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
