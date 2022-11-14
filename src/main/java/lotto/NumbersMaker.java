package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersMaker {
    public List<Integer> makeWinningNumbers(String numbersWithComma) {
        List<Integer> winningNumbers = Arrays.stream(numbersWithComma.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

}
