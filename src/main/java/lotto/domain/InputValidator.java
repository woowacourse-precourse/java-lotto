package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static lotto.view.Constants.*;

public class InputValidator {
    public Integer validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMERIC);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<String> splitForm = splitInput(input);
        for (String piece: splitForm) {
            int number = validateProperNumber(piece);
            numbers.add(number);
        }
        return numbers;
    }

    public int validateProperNumber(String input) {
        int number = validateNumeric(input);
        validateRange(number);
        return number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println(NOT_PROPER_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private List<String> splitInput(String input) {
        String[] splitForm = input.split(",");
        return Arrays.asList(splitForm);
    }
}
