package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Winning {
    private static final int NUMBER_OF_WINNING_NUMBERS = 6;

    public static CheckLotto getWinningLottery() {
        CheckLotto winningLottery;

        Print.enterWinningNumberMessage();
        String winningNumberInput = Console.readLine();
        List<String> splitWinningNumbers = splitInputByComma(winningNumberInput);
        List<Integer> winningNumbers = convertToNumbers(splitWinningNumbers);

        Print.enterBonusNumberMessage();
        String bonusNumberInput = Console.readLine();
        int bonusNumber = convertToNumber(winningNumbers, bonusNumberInput);

        winningLottery = new CheckLotto(winningNumbers, bonusNumber);
        return winningLottery;
    }

    private static List<String> splitInputByComma(String userInput) throws IllegalArgumentException {
        List<String> splitNumber = Arrays.stream(userInput.split(",")).collect(Collectors.toList());

        if (splitNumber.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBERS);
        }

        return splitNumber;
    }

    private static List<Integer> convertToNumbers(List<String> numbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String winningNumber : numbers) {
            int convertNumber = Integer.parseInt(winningNumber);

            if (!Validation.isValidRange(convertNumber)) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.LOTTO_OUT_OF_RANGE);
            }
            if (Validation.checkWinningNumbersDuplication(numbers)) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATE_NUMBER);
            }

            winningNumbers.add(convertNumber);
        }
        return winningNumbers;
    }

    private static int convertToNumber(List<Integer> winningNumbers, String bonusNumberInput) {
        if (!Validation.existOnlyNumber(bonusNumberInput)) {
            throw new IllegalArgumentException(ExceptionMessage.CANNOT_CONVERT_NUMBER);
        }
        if (Validation.checkBonusNumberDuplication(winningNumbers, bonusNumberInput)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER);
        }

        return Integer.parseInt(bonusNumberInput);
    }
}
