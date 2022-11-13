package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersGenerator {
    public static WinningNumbers generateWinningNumbers(String winningNumbersInput) {
        List<String> parsedInputs = Arrays.asList(winningNumbersInput.split(","));
        List<Integer> numbers = new ArrayList<>();

        for (String input : parsedInputs) {
            int number = Integer.parseInt(input);
            numbers.add(number);
        }

        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        return winningNumbers;
    }
}
