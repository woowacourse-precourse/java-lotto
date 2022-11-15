package lotto.inputValidators;

import lotto.domain.LotteryNumber;

import java.util.List;

public class NumberValidator {

    static public boolean isValidWinningNumbers(String[] winningNumbers) {
        if (!isCorrectCountOfNumbers(winningNumbers)) {
            return false;
        }
        if (includeNotNumericCharacter(winningNumbers)) {
            return false;
        }
        if (isNumberOutOfRange(winningNumbers)) {
            return false;
        }
        return true;
    }

    public static boolean isValidBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        if (includeNotNumericCharacter(bonusNumberInput)) {
            return false;
        }

        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (isNumberOutOfRange(bonusNumber)) {
            return false;
        }
        if (winningNumbers.contains(bonusNumber)) {
            return false;
        }
        return true;
    }

    private static boolean isCorrectCountOfNumbers(String[] winningNumbersInput) {
        return winningNumbersInput.length == LotteryNumber.COUNT_OF_LOTTERY_NUMBERS.getNumber();
    }

    public static boolean includeNotNumericCharacter(String[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; ++i) {
            if (includeNotNumericCharacter(inputNumbers[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean includeNotNumericCharacter(String inputNumber) {
        if (inputNumber.charAt(0) == '0') {
            return true;
        }
        for (int i = 0; i < inputNumber.length(); ++i) {
            if (inputNumber.charAt(i) < '0' || inputNumber.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberOutOfRange(String[] numbers) {
        for (int i = 0; i < numbers.length; ++i) {
            int number = Integer.parseInt(numbers[i]);
            if (isNumberOutOfRange(number)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberOutOfRange(int number) {
        return number < LotteryNumber.LOTTERY_MINIMUM_NUMBER.getNumber()
                || number > LotteryNumber.LOTTERY_MAXIMUM_NUMBER.getNumber();
    }
}
