package lotto.domain;

import lotto.validator.UserInputValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(String inputWinningNumbers, String inputBonusNumber) {
        List<Integer> winningNumbers = inputToWinnigNumbers(inputWinningNumbers);
        int bonusNumber = inputToBonusNumber(inputBonusNumber);

        winningNumbersValidate(winningNumbers);
        bonusNumberValidate(bonusNumber, winningNumbers);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void winningNumbersValidate(List<Integer> numbers) {
        UserInputValidator.winNumberCountValidate(numbers);
        UserInputValidator.winNumberRangeValidate(numbers);
        UserInputValidator.winNumberDuplicateValidate(numbers);
    }

    private void bonusNumberValidate(int number, List<Integer> numbers) {
        UserInputValidator.bonusNumberRangeValidate(number);
        UserInputValidator.bonusNumberInWinNumber(number, numbers);
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
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
