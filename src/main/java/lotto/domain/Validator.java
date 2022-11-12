package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.Constants.*;

public class Validator {
    public Integer validateMoney(String input) {
        return validateNumeric(input);
    }

    public List<Integer> validateWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<String> splitForm = splitInput(input);
        for (String piece: splitForm) {
            int number = validateLotteryNumber(piece);
            numbers.add(number);
        }
        return numbers;
    }

    public int validateBonusNumber(String input) {
        return validateLotteryNumber(input);
    }

    private int validateLotteryNumber(String input) {
        int number = validateNumeric(input);
        validateRange(number);
        return number;
    }


    private Integer validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMERIC);
            throw new IllegalArgumentException();
        }
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
