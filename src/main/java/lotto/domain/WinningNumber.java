package lotto.domain;

import lotto.validator.UserInputValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(String inputWinningNumbers, String inputBonusNumber) {
        List<Integer> winnigNumbers = inputToWinnigNumbers(inputWinningNumbers);
        int bonusNumber = inputToBonusNumber(inputBonusNumber);

        winningNumbersValidate(winnigNumbers);
        bonusNumberValidate(bonusNumber);

        this.winningNumbers = winnigNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void winningNumbersValidate(List<Integer> numbers) {
        UserInputValidator.winNumberCountValidate(numbers);
        UserInputValidator.winNumberRangeValidate(numbers);
        UserInputValidator.winNumberDuplicateValidate(numbers);
    }

    private void bonusNumberValidate(int number) {
        UserInputValidator.bonusNumberRangeValidate(number);
    }

    public List<Integer> inputToWinnigNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();

        inputNumbers.trim();
        for (String s : inputNumbers.split(",")) {
            UserInputValidator.isNumValidate(s);
            int num = Integer.parseInt(s);
            numbers.add(num);
        }
        return numbers;
    }

    public int inputToBonusNumber(String inputNumber) {
        int number;

        UserInputValidator.isNumValidate(inputNumber);
        number = Integer.parseInt(inputNumber);

        return number;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
