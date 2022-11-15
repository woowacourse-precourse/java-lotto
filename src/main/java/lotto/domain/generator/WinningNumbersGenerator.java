package lotto.domain.generator;

import lotto.domain.WinningNumbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.validator.ErrorMessages.INPUT_ERROR_MESSAGE;

public class WinningNumbersGenerator {
    public static WinningNumbers generateWinningNumbers(String winningNumbersInput) {
        List<String> parsedInputs = Arrays.asList(winningNumbersInput.split(","));
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String input : parsedInputs) {
                int number = Integer.parseInt(input);
                numbers.add(number);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE.getMessage());
        }

        return new WinningNumbers(numbers);
    }
}
