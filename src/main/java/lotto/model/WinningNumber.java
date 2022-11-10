package lotto.model;

import static lotto.Util.removeSpace;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;

public class WinningNumber {

    private List<Integer> winningNumbers;

    public WinningNumber() {
        String input = removeSpace(InputView.inputWinningNumbers());
        List<Integer> numbers = convertStringListToIntList(separateStringByComma(input));
        this.winningNumbers = validateWinningNumbers(numbers);
    }

    private static List<Integer> validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer winningNumber : numbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private static List<String> separateStringByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static List<Integer> convertStringListToIntList(List<String> list) {
        return list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
