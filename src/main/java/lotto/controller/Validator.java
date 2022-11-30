package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.Constants.*;

public class Validator {
    public Integer validateMoney(String input) {
        int money = validateNumeric(input);
        validateNoMoney(money);
        validateWrongMoney(money);
        return money;
    }

    public List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<String> splitForm = splitInput(input);
        for (String piece: splitForm) {
            int number = validateNumeric(piece);
            validateRange(number);
            numbers.add(number);
        }
        return numbers;
    }

    public Integer validateBonusNumber(String input) {
        int number = validateNumeric(input);
        validateRange(number);
        return number;
    }

    private Integer validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }

    private void validateNoMoney(int paidMoney) {
        if (paidMoney == 0) {
            throw new IllegalArgumentException(BOUGHT_NOTHING);
        }
    }

    private void validateWrongMoney(int paidMoney) {
        if (paidMoney % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND);
        }
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
