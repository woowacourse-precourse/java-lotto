package lotto.domain.generator;

import lotto.domain.WinningNumbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersGenerator {
    private static final String NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자들을 쉼표로 구분해 입력해야 합니다";
    public static WinningNumbers generateWinningNumbers(String winningNumbersInput) {
        List<String> parsedInputs = Arrays.asList(winningNumbersInput.split(","));
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String input : parsedInputs) {
                int number = Integer.parseInt(input);
                numbers.add(number);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
        }

        return new WinningNumbers(numbers);
    }
}
