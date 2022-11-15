package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final InputValidation inputValidation = new InputValidation();
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void inputWinningNumbers() {
        String numbers = Console.readLine();
        inputValidation.validateWinningNumbers(numbers);
        winningNumbers = num2list(numbers);
    }

    private List<Integer> num2list(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void inputBonusNumber() {
        String number = Console.readLine();
        inputValidation.validateBonusNumber(number, winningNumbers);
        bonusNumber = Integer.parseInt(number);
    }

    public Grade getResult(Lotto lotto) {
        int count = 0;
        int bonusCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
                continue;
            }
            if (number.equals(bonusNumber)) {
                bonusCount++;
            }
        }

        if (count == 6) {
            return Grade.FIRST_PRIZE;
        }
        if (count == 5 & bonusCount == 1) {
            return Grade.SECOND_PRIZE;
        }
        if (count == 5) {
            return Grade.THIRD_PRIZE;
        }
        if (count == 4) {
            return Grade.FORTH_PRIZE;
        }
        if (count == 3) {
            return Grade.FIFTH_PRIZE;
        }
        return Grade.NOTHING;
    }
}
