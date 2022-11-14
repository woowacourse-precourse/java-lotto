package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final InputValidation inputValidation = new InputValidation();
    private List<Integer> winningNumbers;

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
}
