package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.Constants.*;

public class InputValidator {
    public int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }

    public List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<String> splitForm = splitInput(input);
        for (String piece: splitForm) {
            int number = validateNumeric(piece);
            numbers.add(number);
        }
        return numbers;
    }

    private List<String> splitInput(String input) {
        String[] splitForm = input.split(",");
        return Arrays.asList(splitForm);
    }
}
