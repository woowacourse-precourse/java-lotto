package lotto.domain;

import static lotto.utils.message.StaticMessagesUtil.INPUT_BONUS_NUMBER;
import static lotto.utils.message.StaticMessagesUtil.INPUT_WINNING_NUMBERS;
import static lotto.utils.validate.NumberValidator.validateNumbersSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ConsoleUtil;
import lotto.utils.validate.NumberValidator;

public class Winning {
    private List<Integer> numbers;
    private int bonusNumber;

    public Winning() {
        this.numbers = new ArrayList<>();
        this.bonusNumber = 0;
    }

    public void inputNumber() {
        ConsoleUtil.showMessage(INPUT_WINNING_NUMBERS.getMessage());
        String input = ConsoleUtil.input();

        String[] splitNumbers = input.split(",");
        validateInputNumber(splitNumbers);

        numbers = convertStringToInteger(splitNumbers);
    }

    public void inputBonusNumber() {
        ConsoleUtil.showMessage(INPUT_BONUS_NUMBER.getMessage());
        String input = ConsoleUtil.input();

        validateBonusNumber(input);

        this.bonusNumber = Integer.parseInt(input);
    }

    private void validateInputNumber(String[] splitNumbers) {
        List<String> distinctNumbers = getDistinctNumbers(splitNumbers);
        validateNumbersSize(distinctNumbers);

        for (String number : distinctNumbers) {
            NumberValidator.validateNumber(number);
        }
    }

    private void validateBonusNumber(String input) {
        NumberValidator.validateDuplicateNumber(numbers, input);
        NumberValidator.validateNumber(input);
    }

    private List<Integer> convertStringToInteger(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> getDistinctNumbers(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
