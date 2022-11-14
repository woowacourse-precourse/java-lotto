package lotto.utils;

import lotto.views.InputView;

import java.util.List;

public class Validation {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    public static void validateOthers(List<Integer> numbers) {
        validateDuplication(numbers);
        validateNumber(numbers);
    }

    private static void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
                throw new IllegalArgumentException(ErrorStatus.OUT_OF_RANGE_NUMBER.printError());
            }
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorStatus.NUMBER_DUPLICATION.printError());
        }
    }

    public static void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorStatus.MONEY_RANGE.printError());
        }
    }

    public static void validateInputMoney(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ErrorStatus.NOT_NUMBER.printError());
        }
    }

    public static void validateWinningNumbers(String[] inputWinningNumbers) {
        try {
            for (String inputWinningNumber : inputWinningNumbers) {
                Integer.parseInt(inputWinningNumber);
            }
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ErrorStatus.NOT_NUMBER.printError());
        }
    }

    public static void validateBonus(String bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(bonusNumber);
        validateBonusDuplication(bonusNumber, winningNumbers);
    }

    private static void validateBonusDuplication(String bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorStatus.BONUS_DUPLICATION.printError());
        }
    }

    private static void validateBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(ErrorStatus.NOT_NUMBER.printError());
        }
    }
}
