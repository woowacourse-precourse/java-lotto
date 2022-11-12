package lotto.domain;

import static lotto.utils.MessagesUtil.INPUT_WINNING_NUMBERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConsoleUtil;
import lotto.validate.NumberValidator;

public class Winning {
    private List<Integer> numbers = new ArrayList<>();
    private NumberValidator validator = new NumberValidator();

    public void inputNumber() {
        ConsoleUtil.showMessage(INPUT_WINNING_NUMBERS.getMessage());
        String input = ConsoleUtil.input();

        String[] splitNumbers = input.split(",");
        validateInputNumber(splitNumbers);

        numbers = convertStringToInteger(splitNumbers);
    }

    private void validateInputNumber(String[] splitNumbers) {
        for (String splitNumber : splitNumbers) {
            validator.validateInputNumber(splitNumber);
        }
    }

    private List<Integer> convertStringToInteger(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
