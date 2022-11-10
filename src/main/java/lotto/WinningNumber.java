package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void readWinningNumbers() {
        String userInputNumbers = Console.readLine().trim();
        String[] inputNumbers = userInputNumbers.split(",");
        validateWinningNumbers(inputNumbers);
        winningNumbers = new ArrayList<>(changeToInteger(inputNumbers));
    }

    public void readBonusNumber() {
        String userInputNumber = Console.readLine().trim();
        validateBonusNumber(userInputNumber);
        bonusNumber = Integer.valueOf(userInputNumber);
    }

    public void validateWinningNumbers(String[] inputNumbers) {
        // 6자리 확인
        validateLength(inputNumbers, 6);
        // 숫자인지 확인
        validateNumeric(inputNumbers);
        // 1 ~ 45인지 확인
        validateRange(inputNumbers);
    }

    public void validateBonusNumber(String userInputNumber) {
        // 숫자인지 확인
        validateIsNumeric(userInputNumber);
        // 1 ~ 45인지 확인
        validateIsInRange(userInputNumber);
    }

    public void validateLength(String[] inputNumbers, int expectedLength) {
        if (inputNumbers.length != expectedLength) {
            ErrorMessage.printNotMatchLengthErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public void validateNumeric(String[] inputNumbers) {
        for (int place = 0; place < inputNumbers.length; place++) {
            validateIsNumeric(inputNumbers[place]);
        }
    }

    public void validateIsNumeric(String input) {
        try {
            Integer inputNumber = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            ErrorMessage.printNonNumericInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(String[] inputNumbers) {
        for (int place = 0; place < inputNumbers.length; place++) {
            validateIsInRange(inputNumbers[place]);
        }
    }

    public void validateIsInRange(String input) {
        if (Integer.valueOf(input) < 1 || Integer.valueOf(input) > 45) {
            ErrorMessage.printNumberRangeErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> changeToInteger(String[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
