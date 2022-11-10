package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;

public class WinningNumber {

    private List<Integer> winningNumbers;

    public WinningNumber() {
        String input = removeSpace(InputView.inputWinningNumbers());
        List<Integer> numbers = convertStringListToIntList(separateStringByComma(input));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer winningNumber : numbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
        this.winningNumbers = numbers;
    }

    private static List<String> separateStringByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static List<Integer> convertStringListToIntList(List<String> list) {
        return list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private String removeSpace(String input) {
        return input.replaceAll("\\s", "");
    }
}
