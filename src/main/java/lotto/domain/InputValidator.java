package lotto.domain;

import java.util.List;

public class InputValidator {

    private static int LOTTERY_MINIMUM_NUMBER = 1;
    private static int LOTTERY_MAXIMUM_NUMBER = 45;
    private static int COUNT_OF_LOTTERY_NUMBERS = 6;

    private boolean includeNotNumericCharacter(String userInput) {
        if (userInput.charAt(0) == '0') {
            return true;
        }
        for (int i = 0; i < userInput.length(); ++i) {
            if (userInput.charAt(i) < '0' || userInput.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    public void validateWinningNumbers(String[] winningNumbers) {
        if (!isCorrectCountOfNumbers(winningNumbers)) {
            System.out.println(ErrorMessage.DRAW_NUMBER_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < winningNumbers.length; ++i) {
            if (includeNotNumericCharacter(winningNumbers[i])) {
                System.out.println(ErrorMessage.DRAW_NUMBER_INPUT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }

            int number = Integer.parseInt(winningNumbers[i]);
            if (isNumberOutOfRange(number)) {
                System.out.println(ErrorMessage.DRAW_NUMBER_INPUT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isCorrectCountOfNumbers(String[] winningNumbersInput) {
        return winningNumbersInput.length == COUNT_OF_LOTTERY_NUMBERS;
    }

    private boolean isNumberOutOfRange(int number) {
        return number < LOTTERY_MINIMUM_NUMBER || number > LOTTERY_MAXIMUM_NUMBER;
    }

    public void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        if (includeNotNumericCharacter(bonusNumberInput)) {
            System.out.println(ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (isNumberOutOfRange(bonusNumber)) {
            System.out.println(ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
