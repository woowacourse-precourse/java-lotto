package lotto;

import lotto.util.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    public static CheckLotto getWinningLottery(List<Integer> winningNumbers,
                                               String bonusNumberInput) throws IllegalArgumentException {
        int bonusNumber = convertToNumber(winningNumbers, bonusNumberInput);
        return new CheckLotto(winningNumbers, bonusNumber);
    }

    private static int convertToNumber(List<Integer> winningNumbers,
                                       String bonusNumberInput) throws IllegalArgumentException {
        Validation.checkBonusNumberDuplication(winningNumbers, bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    public static List<Integer> convertToNumbers(List<String> numbers) throws IllegalArgumentException {
        Validation.checkNumberOfWinningNumber(numbers);
        Validation.checkWinningNumbersDuplication(numbers);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : numbers) {
            int convertNumber = Integer.parseInt(winningNumber);

            Validation.isValidInputRange(convertNumber);
            winningNumbers.add(convertNumber);
        }
        return winningNumbers;
    }

    public static List<String> splitInputByComma(String userInput) throws IllegalArgumentException {
        return Arrays.stream(userInput.split(","))
                     .collect(Collectors.toList());
    }
}
