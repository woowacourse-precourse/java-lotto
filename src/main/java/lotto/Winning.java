package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    public static CheckLotto getWinningLottery(String winningNumberInput,
                                               String bonusNumberInput) throws IllegalArgumentException {
        CheckLotto winningLottery;
        List<String> splitWinningNumbers = splitInputByComma(winningNumberInput);
        List<Integer> winningNumbers = convertToNumbers(splitWinningNumbers);

        int bonusNumber = convertToNumber(winningNumbers, bonusNumberInput);
        winningLottery = new CheckLotto(winningNumbers, bonusNumber);
        return winningLottery;
    }

    private static List<String> splitInputByComma(String userInput) throws IllegalArgumentException {
        List<String> splitNumber = Arrays.stream(userInput.split(","))
                                         .collect(Collectors.toList());
        Validation.checkWinningNumbersDuplication(splitNumber);
        return splitNumber;
    }

    private static List<Integer> convertToNumbers(List<String> numbers) throws IllegalArgumentException {
        Validation.checkNumberOfWinningNumber(numbers);
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : numbers) {
            int convertNumber = Integer.parseInt(winningNumber);

            Validation.isValidInputRange(convertNumber);
            winningNumbers.add(convertNumber);
        }
        return winningNumbers;
    }

    private static int convertToNumber(List<Integer> winningNumbers,
                                       String bonusNumberInput) throws IllegalArgumentException {
        Validation.checkBonusNumberDuplication(winningNumbers, bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }
}
