package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.Constants.*;

public class Validator {
    public Integer validateMoney(String input) {
        validateNumeric(input);
        return stringToInteger(input);
    }

    public List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<String> splitForm = splitInput(input);
        for (String piece: splitForm) {
            validateNumeric(piece);
            int number = stringToInteger(piece);
            validateRange(number);
            numbers.add(number);
        }
        return numbers;
    }

    public int validateBonusNumber(String input) {
        validateNumeric(input);
        int number = stringToInteger(input);
        validateRange(number);
        return number;
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }

    private int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NOT_PROPER_NUMBER);
        }
    }

    private List<String> splitInput(String input) {
        String[] splitForm = input.split(",");
        return Arrays.asList(splitForm);
    }
}
